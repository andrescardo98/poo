package com.andres.eps.domain;

public class Enfermedad {
    private String nombre;
    private int gravedad;

    public Enfermedad(String nombre, int gravedad) {
        this(nombre);
        this.gravedad = gravedad;
    }

    public Enfermedad(String nombre) {
        this.nombre = "nada grave";
    }

    public String getNombre() {
        return nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGravedad(int gravedad){
        if (gravedad ==1){
            System.out.println("Nada grave");
        } else if (gravedad == 2) {
            System.out.println("Medianamente grave");
        } else if (gravedad == 3) {
            System.out.println("Muy grave");
        }
        this.gravedad = gravedad;
    }
}
