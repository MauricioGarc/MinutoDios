package Problema2;

public class Barco {
     private String matricula;
    private double eslora;
    private int anioFabricacion;

    public Barco(String matricula, double eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public String toString() {
        return "Matricula: " + matricula + ", Eslora: " + eslora + " metros, Ano de fabricacion: " + anioFabricacion;
    }
}
