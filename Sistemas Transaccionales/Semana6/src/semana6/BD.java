package semana6;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BD {
    Connection conectar= null;
    String user="root";
    String password="ANma4550.*";
    String bd="semana6";
    String ip="localhost";
    String puerto="3306";
    
    String Cadena="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
   
    public boolean conexcion(){
        try{
            conectar = (Connection) DriverManager.getConnection(Cadena, user, password);
            System.out.println("Conexion exitosa ");
            return true;
        }catch(Exception e){
            System.out.println("No se encontro la base de datos,error: " + e);
        }
        return false;
    }
    
    public boolean InsertClient(ModelCliente cliente) throws SQLException{
        PreparedStatement stmt=null;
        String sql="INSERT INTO clientes (nombre, direccion, correo_electronico, numero_telefono)"
                + "VALUES (?,?,?,?)";
        
        try{
            stmt= conectar.prepareStatement(sql);
            stmt.setString(1, cliente.nombre);
            stmt.setString(2, cliente.direccion);
            stmt.setString(3, cliente.correoElectronico);
            stmt.setString(4, cliente.numeroTelefono);
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Cliente insertado correctamente.");
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            // Cerrar los recursos para evitar fugas de memoria
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
       
        return true;
    }
    public boolean SelectProduct(){
        try{
            java.sql.Statement stmt = conectar.createStatement();
            String sql = "SELECT * FROM productos";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String codigoProducto = rs.getString("codigo_producto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int cantidadInventario = rs.getInt("cantidad_en_inventario");
                double precioVenta = rs.getDouble("precio_venta");

                // Imprimir los datos del producto
                System.out.println("Código: " + codigoProducto);
                System.out.println("Nombre: " + nombre);
                System.out.println("Descripción: " + descripcion);
                System.out.println("Cantidad en inventario: " + cantidadInventario);
                System.out.println("Precio de venta: " + precioVenta);
                System.out.println("===================================");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    public String BuscarCLiente(String nombreCliente){
        try{
            String sql = "SELECT * FROM Clientes WHERE nombre = ?";
            PreparedStatement pstmt = conectar.prepareStatement(sql);
            pstmt.setString(1, nombreCliente);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("id_cliente");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "";
    }
    
    public void ComprarProducto (String nombreCliente, String codigoProducto, int cantidad) throws SQLException{
        try{
            conectar.setAutoCommit(false);
            int id_cliente=0;
            int cantidadInventario=0;
            String precioUni="";
            String sql = "SELECT * FROM Clientes WHERE nombre = ?";
             // Operación 1: Buscar el cliente
            try(PreparedStatement pstmt = conectar.prepareStatement(sql)){
                pstmt.setString(1, nombreCliente);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    id_cliente=rs.getInt("id_cliente");
                }
            }
             // Operación 2: Validar si el producto existe y hay en invetario
            String sql2 = "SELECT cantidad_en_inventario, precio_venta FROM Productos WHERE codigo_producto = ?";
            try(PreparedStatement pstmt2 = conectar.prepareStatement(sql2)){
                pstmt2.setString(1, codigoProducto);
                ResultSet rs = pstmt2.executeQuery();

                // Procesar el resultado
                if (rs.next()) { // Si hay resultados
                     cantidadInventario = rs.getInt("cantidad_en_inventario");
                     precioUni = rs.getString("precio_venta");
                }
            }
            if(cantidadInventario==0 || (cantidadInventario-cantidad) <=0){
                    throw new SQLException("Producto temporalmente agotado");
            }else{
                
             // Operación 3: Insertar datos en la tabla de Facturas 
                 String sqlFactura = "INSERT INTO Facturas (fecha, id_cliente, codigo_producto, cantidad_comprada, precio_unitario, total_factura) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmtFactura = conectar.prepareStatement(sqlFactura)) {
                    pstmtFactura.setString(1, LocalDateTime.now().toString());
                    pstmtFactura.setInt(2, id_cliente);
                    pstmtFactura.setString(3, codigoProducto);
                    pstmtFactura.setInt(4, cantidad);
                    pstmtFactura.setDouble(5, Double.parseDouble(precioUni));
                    pstmtFactura.setDouble(6, (Double.parseDouble(precioUni)*cantidad));

                    // Ejecutar la inserción de la factura
                    int filasFactura = pstmtFactura.executeUpdate();
                    if (filasFactura > 0) {
                        System.out.println("Factura insertada correctamente.");
                    } else {
                        throw new SQLException("Error al insertar la factura.");
                    }
                }
                // Descontar una unidad en la tabla Productos
                String sqlDescuento = "UPDATE Productos SET cantidad_en_inventario = cantidad_en_inventario - 1 WHERE codigo_producto = ? AND cantidad_en_inventario > 0";
                try (PreparedStatement pstmtDescuento = conectar.prepareStatement(sqlDescuento)) {
                    pstmtDescuento.setString(1, codigoProducto);

                    // Ejecutar la actualización del inventario
                    int filasDescuento = pstmtDescuento.executeUpdate();
                    if (filasDescuento > 0) {
                        System.out.println("Inventario actualizado correctamente.");
                    } else {
                        throw new SQLException("No se pudo descontar del inventario, producto no encontrado o sin unidades disponibles.");
                    }
                }
                // Confirmar la transacción
                conectar.commit();
                System.out.println("Transaccion completada con exito.");
            }
        }catch(SQLException e){
            System.out.println("Error durante la transaccion: " + e.getMessage());
            conectar.rollback();
            System.out.println("Transaccion revertida.");
        }
    }
}
