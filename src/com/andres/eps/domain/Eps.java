package com.andres.eps.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Eps {
    public static final byte CAPACIDAD = 100;
    private String nombre;
    private List<Paciente> pacientes;

    public Eps(String nombre) {
        this.nombre = nombre;
        this.pacientes = new ArrayList<>();
    }

    public boolean afiliarPaciente(long cedula, String nombre){
        Paciente verificarPaciente = this.buscarPaciente(cedula);
        if (verificarPaciente == null && this.pacientes.size() < CAPACIDAD){
            Paciente pacienteAagregar = new Paciente(cedula,nombre);
            this.pacientes.add(pacienteAagregar);
            System.out.println("Paciente con cedula " + cedula + " y nombre " + nombre + " ha sido afiliado");
            return true;
        }
        System.out.println("La persona no se ha podido afiliar porque ya existe");
        return false;
    }

    public void sacarPaciente(long cedula){
        Paciente verificarPaciente = this.buscarPaciente(cedula);
        if (verificarPaciente != null){
            this.pacientes.remove(verificarPaciente);
            System.out.println("El paciente con cedula " + cedula + " ha sido eliminado");
        }else {
            System.out.println("El paciente con cédula " + cedula + " no se encuentra afiliado");
        }
    }

    public Paciente buscarPaciente(long cedula){
        Paciente pacienteAretornar = null;
        for (Paciente paciente : this.pacientes){
            if (paciente.getCedula() == cedula){
                pacienteAretornar = paciente;
                System.out.println("El paciente se encuentra afiliado");
                return pacienteAretornar;
            }
        }
        return pacienteAretornar;

//        return this.pacientes.stream().filter(paciente -> paciente.getCedula() == cedula).findFirst().orElse(null);
    }

    public List<Paciente> buscarPacientesPorEnfermedad(String enfermedad){
        List<Paciente> listaPacientes = new ArrayList<>();
        for (Paciente paciente : this.pacientes){
            if (paciente.getEnfermedades().equals(enfermedad)){
                listaPacientes.add(paciente);
                return listaPacientes;
            }
        }
        return null;
    }

    public List<Paciente> obtenerPacientesSinEnfermedades(){
        List<Paciente> pacientesSinEnfermedades = new ArrayList<>();
        for (Paciente paciente : this.pacientes){
            if (paciente.getEnfermedades().isEmpty()){
                pacientesSinEnfermedades.add(paciente);
                return pacientesSinEnfermedades;
            }
        }
        return null;
    }

    public void ordenarPacientesPorNombre(){
        this.pacientes.sort(Comparator.comparing(Paciente::getNombre));
    }




    public String getNombre() {
        return nombre;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
