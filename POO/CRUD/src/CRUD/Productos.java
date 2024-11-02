package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Productos extends BD{
    Connection conectarp= null;
    public Productos(){
        conexcion(false);
        conectarp = conectar;
    }
    public boolean createProduct(Producto produ){
        boolean salir = true;
        
        if (conectarp!=null){
            PreparedStatement stmt=null;
            String sql="INSERT INTO Productos (codigo_producto, "
                    + "nombre, descripcion, cantidad_en_inventario, "
                    + "precio_venta, productoActivo)"
                    + "VALUES (?,?,?,?,?,?)";
            
            try{
                stmt= conectarp.prepareStatement(sql);
                stmt.setString(1, produ.codigo_prodcuto);
                stmt.setString(2, produ.nombre);
                stmt.setString(3, produ.descripcion);
                stmt.setInt(4, produ.cantidad_en_inventario);
                stmt.setDouble(5, produ.precio_venta);
                stmt.setDouble(6, 1);
                int filasInsertadas = stmt.executeUpdate();
                if (filasInsertadas > 0) {
                    System.out.println("\r\n        Producto insertado correctamente.");
                } 
            }catch(SQLException e){
                salir = false;
                e.printStackTrace();
            }finally {
                // Cerrar los recursos para evitar fugas de memoria
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else {
            System.out.println("\r\n        Error: al intentar conectar con la base de datos");
            salir = false;
        }
        
       return salir;
    }
    public Producto readProduct(String CodigoProducto){
        Producto prod= new Producto();
        prod.codigo_prodcuto=CodigoProducto;
        String sql = "SELECT * FROM Productos WHERE codigo_producto = ?";
        try(PreparedStatement stmt = conectarp.prepareStatement(sql)) {
            stmt.setString(1, CodigoProducto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                prod.nombre = rs.getString("nombre");
                prod.descripcion = rs.getString("descripcion");
                prod.cantidad_en_inventario = rs.getInt("cantidad_en_inventario");
                prod.precio_venta = rs.getDouble("precio_venta");
                prod.producto_activo = rs.getInt("productoActivo");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return prod;
    }
    public boolean deleteProduct(String CodigoProducto){
        boolean salir = true;
        
        if (conectarp!=null){
            String sql = "UPDATE Productos SET productoActivo = 0 WHERE "
                    + "codigo_producto = ?";

            try (PreparedStatement stmt = conectarp.prepareStatement(sql)) {
                stmt.setString(1, CodigoProducto);

                int filasActualizadas = stmt.executeUpdate();

                if (filasActualizadas > 0) {
                    salir = true;
                } else {
                    salir=false;
                    System.out.println("        No se encontro el producto "
                            + "con el codigo especificado.");
                }
            } catch (Exception e) {
                salir=false;
                e.printStackTrace();
            } 
        }else{
            
        }
        return salir;
    }
    public boolean updateProduct(Producto produ){
        boolean salir = true;
        if(conectarp!=null){
            String sql = "UPDATE Productos "
                    + "SET nombre = ?, "
                    + "descripcion = ?, "
                    + "cantidad_en_inventario = ?, "
                    + "precio_venta = ? "
                    + "WHERE codigo_producto = ?";

            try (PreparedStatement stmt = conectarp.prepareStatement(sql)) {
                stmt.setString(1, produ.nombre);
                stmt.setString(2, produ.descripcion);
                stmt.setInt(3, produ.cantidad_en_inventario);
                stmt.setDouble(4, produ.precio_venta);
                stmt.setString(5, produ.codigo_prodcuto);

                int filasActualizadas = stmt.executeUpdate();

                if (filasActualizadas > 0) {
                    System.out.println("\r\n        Actualizacion realizada "
                            + "correctamente.");
                } else {
                    System.out.println("\r\n        No se encontró el producto "
                            + "con el código especificado.");
                }
            } catch (Exception e) {
                salir = false;
                e.printStackTrace();
            }
        }
        else {
            System.out.println("\r\n        Error: al intentar conectar con "
                    + "la base de datos");
            salir = false;
        }
        return salir;
    }
}
