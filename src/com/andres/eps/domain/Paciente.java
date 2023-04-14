package com.andres.eps.domain;

import java.util.List;

public class Paciente {
    private long cedula;
    private String nombre;
    private List<Enfermedad> enfermedades;

    public Paciente(long cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public List<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void setEnfermedades(List<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }
}
