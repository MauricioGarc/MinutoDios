package Problema3;

import java.util.Scanner;

public class Cliente {
     private String nombre;
    private String apellido;
    private int edad;
    private String representanteNombre;
    private String representanteApellido;

    public Cliente(){
        
    }
    public Cliente(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        if (edad < 18) {
            System.out.print("  Ingrese el nombre del representante: ");
            this.representanteNombre = new Scanner(System.in).nextLine();
            System.out.print("  Ingrese el apellido del representante: ");
            this.representanteApellido = new Scanner(System.in).nextLine();
        }
    }

    public boolean esMenorEdad() {
        return edad < 18;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getRepresentante() {
        return representanteNombre + " " + representanteApellido;
    }
}
