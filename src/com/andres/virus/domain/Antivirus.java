package com.andres.virus.domain;

import java.util.List;

public class Antivirus {

    public static String scanVirus(List<Viruseable> viruseables){
        int virusCount = 0;

        for (Viruseable viruseable : viruseables){
            if (viruseable.hasVirus()){
                virusCount++;
                System.out.println(viruseable.getName());
            }
        }
        return "It found " + virusCount + " virus";
    }
}
