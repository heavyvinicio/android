package net.unir.gestionfarmaciaunir.modelo;

import java.io.Serializable;

/**
 * Created by pocho on 10/02/18.
 */

public class Persona implements Serializable {


    private String nombre;
    private String direccion;


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
