package com.andres.fpc.domain;

import java.util.List;

public class Tournament {
    public List<Team> teams;

    public void printTeamPlayers(){
        for (Team t : teams){
            for (Player p : t.players){
                System.out.println(p.name);
            }
        }
    }
}
