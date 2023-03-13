package com.andres.fpc.domain;

import java.util.List;

public class Team {
    public Pet pet;
    public List<Player> players;

    public Team(List<Player> players){
        this.players = players;
    }
}
