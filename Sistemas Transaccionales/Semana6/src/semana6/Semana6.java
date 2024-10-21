package semana6;

import java.sql.SQLException;
import java.util.Scanner;

public class Semana6 {
    
    public static void main(String[] args) throws SQLException {
        boolean Salir = true;
        BD conec = new BD();
        Scanner option = new Scanner(System.in);
        if (conec.conexcion()) {
            System.out.println("Bienvedio acaba de ingresar al sistema de CompuTienda");
            while(Salir){
                System.out.println("\r\n    1. Registrarse Pagina CompuTienda");
                System.out.println("    2. Buscar Datos del producto ");
                System.out.println("    3. Realizar compra ");
                System.out.println("    4. Salir del sistema ");
                
                System.out.print("\r\nSeleccione una de las anteriores opciones: ");
                option = new Scanner(System.in);
                String Opt = option.nextLine();
                
                switch(Opt){
                    case "1":
                        ModelCliente cliente = new ModelCliente();
                        option = new Scanner(System.in);
                        System.out.print("Inserte el nombre del Comprador: ");
                        cliente.nombre=option.nextLine();
                        
                        option = new Scanner(System.in);
                        System.out.print("Inserte la direccion del Comprador: ");
                        cliente.direccion=option.nextLine();
                       
                        option = new Scanner(System.in);
                        System.out.print("Inserte el correo del Comprador: ");
                        cliente.correoElectronico=option.nextLine();
                       
                        option = new Scanner(System.in);
                        System.out.print("Inserte el telefono del Comprador: ");
                        cliente.numeroTelefono=option.nextLine();
                        
                        conec.InsertClient(cliente);
                        break;
                    case "2":
                        conec.SelectProduct();
                        break;
                    case "3":
                        option = new Scanner(System.in);
                        System.out.print("Inserte el nombre del Comprador: ");
                        String nombre= option.nextLine();
                        option = new Scanner(System.in);
                        System.out.print("Inserte el codigo del producto: ");
                        String codProduc= option.nextLine();
                        option = new Scanner(System.in);
                        System.out.print("Inserte la cantidad a comprar: ");
                        int cantidad= option.nextInt();
                        conec.ComprarProducto(nombre,codProduc,cantidad);
                        break;
                    case "4":
                        System.out.println("    Saliendo del sistema en linea...");
                        Salir=false;
                        break;
                    default:
                        System.out.println("    Opcion no contemplada...");
                        break;
                        
                }
            }
        }
    }
}
