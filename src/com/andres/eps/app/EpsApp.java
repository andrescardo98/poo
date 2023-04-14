package com.andres.eps.app;

import com.andres.eps.domain.Enfermedad;
import com.andres.eps.domain.Eps;
import com.andres.eps.domain.Paciente;

public class EpsApp {
    public static void main(String[] args) {
        Eps eps = new Eps("SURA");

        Paciente paciente1 = new Paciente(1038417228, "Andres Cardona");
        Paciente paciente2 = new Paciente(1038417227, "Lucas Restrepo");
        Paciente paciente3 = new Paciente(1038417226, "Felipe Zuluaga");
        Paciente paciente4 = new Paciente(1038417225, "Sara Betancur");
        Paciente paciente5 = new Paciente(1038417224, "Hilda Jaramillo");
        Paciente paciente6 = new Paciente(1038417223, "Pablo Rendon");
        Paciente paciente7 = new Paciente(1038417222, "Jeronimo Toro");
        Paciente paciente8 = new Paciente(1038417221, "Isabella Jimenez");

        Enfermedad enfermedad1 = new Enfermedad("COVID");
        Enfermedad enfermedad2 = new Enfermedad("Viruela");
        Enfermedad enfermedad3 = new Enfermedad("Gripe");

        eps.getPacientes().add(paciente1);
        eps.getPacientes().add(paciente2);
        eps.getPacientes().add(paciente3);
        eps.getPacientes().add(paciente4);
        eps.getPacientes().add(paciente5);
        eps.getPacientes().add(paciente6);
        eps.getPacientes().add(paciente7);
        eps.getPacientes().add(paciente8);

        eps.buscarPaciente(1038417228);
        eps.sacarPaciente(1038417223);
        eps.afiliarPaciente(1038417228,"Pedro");


//        eps.sacarPaciente(1038417228);

    }
}
