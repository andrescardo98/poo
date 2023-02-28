package com.andres.soccerPlayer.domain;

import java.util.Date;

public class SoccerPlayer {
    public String name;
    public String lastName;
    public byte age;
    public Date birthDate;
    public String id;
    public String nationality;
    public String team;
    public double height;
    public double weight;
    public String position;
    public String skillfulLeg;
    public short scoredGoals;
    public double speed;
    public double strength;
    public int shoot;
    public byte shootingSpeed;
    public byte dorsal;
    public int timePlayed;

    public void passing(){
    }

    public void scoring(int amount){
        this.scoredGoals += amount;
    }

    public void shooting(){
        this.shoot ++;https://github.com/andrescardo98/poo.git

    }

    public void quiting(){

    }

    public void running(){

    }

    public boolean training(){
        return true;
    }

    public String getScoredGoals(){
        return "Today " + this.name + " " + this.lastName + " scored " + this.scoredGoals + " goals in " + this.timePlayed + " minutes.";
    }
}
