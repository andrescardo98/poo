package com.andres.twitch.domain;

import java.util.Date;
import java.util.List;

public class Twitch {
    private List<Streamer> streamers;
    private String colorBrand;
    private Date creationDate;
    private int currentStreamers;
    private int currentUsers;
    private int currentViewers;
    private String currentGame;

    public Twitch(int currentUsers, int currentViewers, String currentGame) {
        this.currentUsers = currentUsers;
        this.currentViewers = currentViewers;
        this.currentGame = currentGame;
    }

    public boolean startStreaming(){
        System.out.println(this.streamers + "you are streaming now.");
        return true;
    }

    public boolean endStreaming(){
        System.out.println(this.streamers + "you have finished your streaming.");
        return true;
    }

    public String createUser(){
        return "Your account has been created successfully!";
    }

    public String updateGame(){
        return "Game has updated to: " + currentGame;
    }

    public void getStreamers(){
        for (Streamer s : streamers){
            System.out.println(s.getName());
        }
    }
}
