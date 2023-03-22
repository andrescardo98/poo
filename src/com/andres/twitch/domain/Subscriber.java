package com.andres.twitch.domain;

import java.util.List;

public class Subscriber {
    private List<Streamer> subscribedStreamers;
    private String name;
    private String user;
    private String email;
    private String password;
    private int followedStreamer;
    private int subscribedStreamer;
    private boolean notification;
    private String currentStreamer;

    public Subscriber(String name, String user, int followedStreamer, String currentStreamer) {
        this.name = name;
        this.user = user;
        this.followedStreamer = followedStreamer;
        this.currentStreamer = currentStreamer;
    }

    public boolean paySubscription(){
        System.out.println("You are subscribed to " + this.subscribedStreamers + "channel!");
        return true;
    }

    public boolean unsubscribe(){
        return true;
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
