package Problema2;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Alquiler> alquileres;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.alquileres = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void agregarAlquiler(Alquiler alquiler) {
        alquileres.add(alquiler);
    }
}
