package com.andres.fpc.domain;

import java.util.List;

public class Team {
    private String name;
    private Pet pet;
    private Stadium stadium;
    private List<Player> players;

    public Team(List<Player> players){
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Pet getPet() {
        return pet;
    }

    public String getName() {
        return name;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
