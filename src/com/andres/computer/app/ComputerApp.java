package com.andres.computer.app;

import com.andres.computer.domain.Computer;

public class ComputerApp {
    public static void main(String[] args) {
        Computer myComputer = new Computer("ASUS","Black","RYZEN AMD 5000",1.8);
        Computer myOtherComputer = new Computer("ASUS","Black","RAYZEN AMD 5000",16,15.6,1.8,"Vivobook 15 Pro");

        myComputer.starting();
        myComputer.executingProgram();
    }

}
