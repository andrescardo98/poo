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
    public int passes;
    public int quitedBall;
    public double distanceTraveled;

    public void passing(int amount){
        this.passes += amount;
    }

    public void scoring(int amount){
        this.scoredGoals += amount;
    }

    public void shooting(){
        this.shoot ++;

    }

    public void quiting(int amount){
        this.quitedBall += amount;
    }

    public void running(double distance){
        this.distanceTraveled += distance;
    }

    public boolean training(){
        return true;
    }

    public String getScoredGoals(){
        return this.name + " " + this.lastName + " statistics:" + "\nGoals scored: " + this.scoredGoals + " goals. \nPasses made: " + this.passes + " passes. " + "\nDistance traveled: " + this.distanceTraveled + "km." + "\nPlayed time: " + this.timePlayed + " minutes.";
    }
}
