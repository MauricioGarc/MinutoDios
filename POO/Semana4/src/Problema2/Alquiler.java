package Problema2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Alquiler {
    private List<Alquiler> alquileres= new ArrayList<>();
    private Cliente cliente;
    private Barco barco;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int posicionAmarre;
    private static final double PRECIO_POR_DIA = 25000;
    
    public Alquiler(){
        
    }
    public Alquiler(Cliente cliente, Barco barco, LocalDate fechaInicio, LocalDate fechaFin, int posicionAmarre) {
        this.cliente = cliente;
        this.barco = barco;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.posicionAmarre = posicionAmarre;
    }

    public String getAlquileres() {
        String Info="";
        for (Alquiler alquiler : alquileres) {
            Info+="Cliente: "+ alquiler.cliente.getNombre() +"\r\n" +
                  "Barco: "+ alquiler.barco.getMatricula() +"\r\n" +
                  "FechaInicio: "+ alquiler.fechaInicio +"\r\n" +
                  "FechaFin: "+  alquiler.fechaFin+"\r\n" +
                  "Posicion Amarre: "+ alquiler.posicionAmarre +"\r\n" +
                  "Costo total: "+ getcalcularCosto(alquiler.fechaInicio, alquiler.fechaFin) +"\r\n" +
                  "----------------------------\r\n";
        }
        return Info;
    }
   
    public void Registrar(Alquiler addAqui){
        alquileres.add(addAqui);
    }
    public double calcularCosto() {
        long diasOcupacion = ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1; // Incluye el día de inicio
        return diasOcupacion * PRECIO_POR_DIA;
    }
    public double getcalcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long diasOcupacion = ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1; // Incluye el día de inicio
        return diasOcupacion * PRECIO_POR_DIA;
    }
     public void imprimirRecibo() {
        System.out.println("===============================");
        System.out.println("    Recibo de Alquiler   ");
        System.out.println("===============================");
        System.out.println("Datos del Cliente: ");
        System.out.println("    Nombre: " + cliente.getNombre());
        System.out.println("    Barco: " + barco);
        System.out.println("Informacion de Arrendamiento: ");
        System.out.println("    Fecha de Inicio: " + fechaInicio);
        System.out.println("    Fecha de Fin: " + fechaFin);
        System.out.println("    Posicion del Amarre: " + posicionAmarre);
        System.out.println("    Dias de ocupacion: " + 
                (ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1));
        System.out.println("    Total a Pagar: $" + calcularCosto());
        System.out.println("===============================");
        System.out.println("    Fin de la impresion   ");
        System.out.println("===============================");
    }
     
}
