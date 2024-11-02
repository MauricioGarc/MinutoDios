package Problema2;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Problema2 {
    
    public static void main(String[] args) {
        Scanner LeerDato= new Scanner(System.in);
        Alquiler alquiler2 = new Alquiler();
        while(true){
            System.out.println("Sistema Iniciado....");
            System.out.println("\r\n  1. Registrar Factura\r\n"
                       + "  2. Mostrar listado de clientes \r\n"
                       + "  3. Salir \r\n");
            System.out.print("Seleccione un opcion para continuar: ");
            int dato=LeerDato.nextInt();
            System.out.println("");
            if (dato==1) {
                LeerDato= new Scanner(System.in);
                System.out.print("Ingrese el Nombre: ");
                String nombre=LeerDato.next();
                LeerDato= new Scanner(System.in);
                System.out.print("Ingrese la Matricula del barco: ");
                String matricula=LeerDato.next();
                LeerDato= new Scanner(System.in);
                System.out.print("Ingrese la eslora del barco: ");
                int eslora=LeerDato.nextInt();
                LeerDato= new Scanner(System.in);
                System.out.print("Ingrese el year  Fabricacion del barco : ");
                int yearF = LeerDato.nextInt();
                LeerDato= new Scanner(System.in);
                System.out.print("Ingrese dias de arrendar: ");
                int dias = LeerDato.nextInt();
                LeerDato= new Scanner(System.in);
                System.out.print("Ingrese la posicion de amarre: ");
                int amarre=LeerDato.nextInt();
                
                LocalDateTime FechaActual = LocalDateTime.now();
                LocalDateTime FechaFinal = FechaActual.plusDays(dias);

                 Cliente cliente = cliente = new Cliente(nombre);
                Barco barco = new Barco(matricula, eslora, yearF);
                Alquiler alquiler = new Alquiler(cliente, barco, 
                        LocalDate.of(FechaActual.getYear(),FechaActual.getMonthValue(), FechaActual.getDayOfMonth()),
                        LocalDate.of(FechaFinal.getYear(), FechaFinal.getMonthValue(), FechaFinal.getDayOfMonth()), 
                        amarre);
                
                cliente.agregarAlquiler(alquiler);
                alquiler2.Registrar(alquiler);
                alquiler.imprimirRecibo();
            }else if (dato==2) {
                System.out.println("=====================");
                System.out.println("Imprimiendo arriendos");
                System.out.println("=====================");
                System.out.println(alquiler2.getAlquileres());
                System.out.println("=====================");
                System.out.println("Fin de la impresion");
                System.out.println("=====================");
            }else {
                break;
            } 
        }
    }
}
