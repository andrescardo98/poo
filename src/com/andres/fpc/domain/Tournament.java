package com.andres.fpc.domain;

import java.util.List;

public class Tournament {
    private List<Team> teams;
    private String name;
    private String type;
    private int semester;


    public void printTeamPlayers(){
        for (Team t : teams){
            for (Player p : t.getPlayers()){
                System.out.println(p.getName());
            }
        }
    }
    public List<Team> getTeams(){
        return teams;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSemester() {
        return semester;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}