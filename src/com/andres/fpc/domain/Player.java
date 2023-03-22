package com.andres.fpc.domain;

public class Player {
    private String name;
    private String position;
    private String skillfulLeg;
    private int dorsal;

    public Player(String name, String position, String skillfulLeg) {
        this.name = name;
        this.position = position;
        this.skillfulLeg = skillfulLeg;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getSkillfulLeg() {
        return skillfulLeg;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
}
