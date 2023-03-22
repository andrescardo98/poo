package com.andres.twitch.domain;

import java.util.List;

public class Follower {
    private List<Streamer> followedStreamers;
    private String name;
    private String user;
    private String email;
    private String password;
    private int followedStreamer;
    private boolean notification;
    private String currentStreamer;

    public Follower(int followedStreamer, boolean notification, String currentStreamer) {
        this.followedStreamer = followedStreamer;
        this.notification = notification;
        this.currentStreamer = currentStreamer;
    }

    public boolean signUp(){
        return true;
    }

    public boolean logIn(){
        return true;
    }

    public boolean followStreamer(){
        this.followedStreamer++;
        return true;
    }

    public boolean unfollowStreamer(){
        this.followedStreamer--;
        return true;
    }

    public boolean watchingStreaming(){
        return true;
    }

    public boolean stopWatchingStreaming(){
        return true;
    }

    public boolean turnOnNotification(){
        System.out.println(this.currentStreamer + "is streaming now. Join it!");
        return true;
    }

    public boolean turnOffNotification(){
        System.out.println(this.user + "You aren't going to receive more info about " + this.currentStreamer);
        return true;
    }

    public String getName(){
        return name;
    }

    public String searchStreamer(){
        return "You are watching " + this.currentStreamer;
    }
}