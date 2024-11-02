package Problema1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problema1 {
    public static void main(String[] args) {
        Carreras CarrerasDisponibles = new Carreras();
        Estudiantes students = new Estudiantes();
       
        List<String> Carreras = Arrays.asList(CarrerasDisponibles.consultarCarreras());
        
        System.out.println("Bienvenidos a la Universidad, a continuacion\r\n"
                + "se mostrar un menu de carreras:");
       
        for (int i = 0; i < Carreras.size(); i++) {
            System.out.println(tabulador(1)+(i+1)+". "+ Carreras.get(i));
        }
        System.out.println();
        Scanner LeerDato= new Scanner(System.in);
        
        System.out.print(tabulador(2) + "Por favor seleccione la carrera que corresponde: ");
        int Carrera = LeerDato.nextInt();
        System.out.println(tabulador(2) +"Se ha seleccionado la carrera: " +
                Carreras.get(Carrera-1));
        System.out.println();
        System.out.print("Por favor ingrese su numero de documento: ");
        String Docu =LeerDato.next();
        String existeEstudiante = students.getIdAlumno(Docu, Carreras.get(Carrera-1) );
        if (existeEstudiante!="") {
            System.out.println("Estudiante encontrado: \r\n" + 
                    students.getAlumno(existeEstudiante));
       
            System.out.println("\r\n  1. Informacion correcta\r\n"
                       + "  2. Informacion incorrecta \r\n"
                       + "  3. Actualizar informacion \r\n");
            System.out.print("Por favor ingrese una opcion: ");
            int opcionMenu = LeerDato.nextInt();
            
            if (opcionMenu==1 || opcionMenu==3) {
                
                if(opcionMenu==3){
                    System.out.print("  Por favor ingrese sus nombre: ");
                    LeerDato= new Scanner(System.in);
                    String name = LeerDato.next();
                    System.out.print("  Por favor ingrese sus apellidos: ");
                    LeerDato= new Scanner(System.in);
                    String lastName = LeerDato.next();
                    System.out.print("  Por favor ingrese su Direccion: ");
                    LeerDato= new Scanner(System.in);
                    String address = LeerDato.next();
                    System.out.print("  Por favor ingrese su telefono: ");
                    LeerDato= new Scanner(System.in);
                    int phone = LeerDato.nextInt();

                    if (students.setAlumno(existeEstudiante, name, lastName, address, phone)) {
                        System.out.println("\r\nIformacion actualizada con exito,\r\n"
                      + students.getAlumno(existeEstudiante));
                    }
                }
                
                int semestre = students.getSemestre(existeEstudiante);
                String tipo =  students.getModalidad(existeEstudiante);
                int creditosP =  students.getCreditosPerdidos(existeEstudiante);
                double precioBase = students.getPreciobase(existeEstudiante);
                
                double calculoPb = precioBaseCal(semestre, precioBase);
                double calculoCre = creditoPagar(semestre, creditosP);
                System.out.println("\r\n Imprimiendo Recibo de Inscripcion ");
                System.out.println("=======================================");
                System.out.println("     Universidad Minuto de Dios ");
                System.out.println("=======================================");
                System.out.println("Datos del Estudiante:");
                System.out.println(students.getAlumno(existeEstudiante));
                
                System.out.println("Informacion de Pago:");
                
                System.out.println("    El semestre es: " + semestre);
                System.out.println("    Modalidad: " + tipo);
                if (tipo.equals("Virtual")) {
                    System.out.println("    El precio base es: " + precioBase);
                    System.out.println("    Procentaje (5%) por semestre: " + (calculoPb-precioBase));
                    System.out.println("    Total a pagar es: " + calculoPb);
                }else if(tipo.equals("Presencial")){
                    System.out.println("    El precio base es: " + calculoPb);
                    System.out.println("    Procentaje (5%) por semestre: " + (calculoPb-precioBase));
                    System.out.println("    Cantidad de creditos pendientes: " + creditosP);
                    System.out.println("    Total creditos a pagar: " + calculoCre);
                    System.out.println("    Total  a pagar: " + (calculoCre+calculoPb));
                }
                System.out.println("=======================================");
                System.out.println("     Fin de la Impresion   ");
                System.out.println("=======================================");
            }else{
                System.out.println("Por favor validar la informacion ingresada,\r\n"
                  + "en caso de que todo este bien,  contactar con el administrador.");
                return;
            }                    
        }else{
          System.out.println("El estudiante no existe para la carrera seleccionada,\r\n"
                  + "por favor contactar con el administrador o verifique\r\n"
                  + "la carrera selccionada.");  
        }
    }
    
    public static double precioBaseCal(int semestre, double precioBase){
        if (semestre<5) {
            return precioBase;
        }else{
             return((precioBase*0.05)+precioBase);
        }          
    }
   
    public static double creditoPagar(int semestre, int creditosPendientes){
       double retorno=0;
        if (creditosPendientes!=0) {
            if (semestre <= 3) {
                retorno=20*creditosPendientes;
            }else if (semestre <= 6 || semestre >= 4 ) {
                retorno=25*creditosPendientes;
            }else{
                retorno=30*creditosPendientes;
            } 
        }else{
            return retorno;
        }
        return retorno;
    }
    
    public static String tabulador(int numero){
        String espacios="  ";
        for (int i = 0; i < numero; i++) {
            espacios+="  ";
        }
        return espacios;
    }
    
}


