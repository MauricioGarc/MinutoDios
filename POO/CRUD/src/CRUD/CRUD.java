package CRUD;

import java.sql.SQLException;
import java.util.Scanner;

public class CRUD {
    
    public static void main(String[] args) throws SQLException {
        boolean Salir = true;
        BD conec = new BD();
        Scanner option = new Scanner(System.in);
        if (conec.conexcion(true)) {
            System.out.println("Bienvedio acaba de ingresar al sistema de CompuTienda");
            while(Salir){
                System.out.println("\r\n===========================================");
                System.out.println("              Menu principal   ");
                System.out.println("===========================================");
                System.out.println("\r\n    1. Registrarse Pagina CompuTienda");
                System.out.println("    2. Productos ");
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
                        boolean IngresarBucle=true;
                        while(IngresarBucle){
                            System.out.println("\r\n===========================================");
                            System.out.println("    Ha ingresado al modulo de productos");
                            System.out.println("===========================================");
                            System.out.println("        1. Crear Producto.");
                            System.out.println("        2. Actualizacion del Producto. ");
                            System.out.println("        3. Buscar porducto.");
                            System.out.println("        4. Eliminacion del producto.");
                            System.out.println("        5. Salir Modulo princirpal ");

                            System.out.print("\r\nSeleccione una de las anteriores opciones: ");
                            option = new Scanner(System.in);
                            String Opt1 = option.nextLine();
                            Productos prodCrud = new  Productos();
                            Producto prodArt= null;
                            switch (Opt1){
                                case "1":
                                    prodArt= new Producto();
                                    System.out.print("        Ingresar codigo del Producto: ");
                                    option = new Scanner(System.in);
                                    prodArt.codigo_prodcuto = option.nextLine();
                                    System.out.print("        Ingresar el nombre del Producto: ");
                                    option = new Scanner(System.in);
                                    prodArt.nombre = option.nextLine();
                                    System.out.print("        Ingresar la descripcion del Producto: ");
                                    option = new Scanner(System.in);
                                    prodArt.descripcion = option.nextLine();
                                    System.out.print("        Ingresar la cantidad del Producto: ");
                                    option = new Scanner(System.in);
                                    prodArt.cantidad_en_inventario = option.nextInt();
                                    System.out.print("        Ingresar la precio de venta del Producto: ");
                                    option = new Scanner(System.in);
                                    prodArt.precio_venta = option.nextDouble();
                                    prodArt.producto_activo =1;
                                    prodCrud.createProduct(prodArt);
                                    break;
                                case "2":
                                    prodArt= new Producto();
                                    System.out.print("        Ingresar codigo del Producto: ");
                                    option = new Scanner(System.in);
                                    prodArt.codigo_prodcuto = option.nextLine();
                                    System.out.print("        Ingresar el nombre del Producto a Actualizar: ");
                                    option = new Scanner(System.in);
                                    prodArt.nombre = option.nextLine();
                                    System.out.print("        Ingresar la descripcion del Producto a Actualizar: ");
                                    option = new Scanner(System.in);
                                    prodArt.descripcion = option.nextLine();
                                    System.out.print("        Ingresar la cantidad del Producto a Actualizar: ");
                                    option = new Scanner(System.in);
                                    prodArt.cantidad_en_inventario = option.nextInt();
                                    System.out.print("        Ingresar la precio de venta del Producto a Actualizar: ");
                                    option = new Scanner(System.in);
                                    prodArt.precio_venta = option.nextDouble();
                                    
                                    prodCrud.updateProduct(prodArt);
                                    break;
                                case "3":
                                    prodArt= new Producto();
                                    System.out.print("        Ingresar codigo del Producto: ");
                                    option = new Scanner(System.in);
                                    String codigo=option.next();
                                    prodArt = prodCrud.readProduct(codigo);
                                    
                                    System.out.println("\r\n        Nombre del Producto: " + prodArt.nombre);
                                    System.out.println("        Descripcion del Producto: " + prodArt.descripcion);
                                    System.out.println("        Cantidad del Producto: " + prodArt.cantidad_en_inventario);
                                    System.out.println("        Valor de Venta del Producto: " + prodArt.precio_venta);
                                    if(prodArt.producto_activo == 1) System.out.println("        Producto Activo ");
                                    else System.out.println("        Proucto Borrado");
                                    break;
                                case "4":
                                    System.out.print("        Ingresar codigo del Producto: ");
                                    option = new Scanner(System.in);
                                    String codigo_prodcuto = option.nextLine();
                                    if(prodCrud.deleteProduct(codigo_prodcuto)) 
                                        System.out.println("\r\n        Proucto Borrado con Exito");
                                    else  
                                        System.out.println("\r\n        Proucto no se pudo borrar");
                                    break;
                                default:
                                    System.out.println("Ha salido del modulo de productos");
                                    IngresarBucle = false;
                                    break;
                            }
                        }
                        
                        
                        //conec.SelectProduct();
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
