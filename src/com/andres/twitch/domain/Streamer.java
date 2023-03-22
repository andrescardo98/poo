package com.andres.twitch.domain;

import java.util.List;

public class Streamer {
    private List<Follower> followers;
    private List<Subscriber> subscribers;
    private String name;
    private String user;
    private String password;
    private int currentFollowers;
    private String email;
    private int currentSubscribers;
    private int age;
    private String currentGame;
    private int currentIncomes;
    private int streamingTime;
    private int averageViewers;

    public Streamer(int currentFollowers, int currentSubscribers, String currentGame, int currentIncomes, int streamingTime, int averageViewers) {
        this(currentFollowers, currentSubscribers);
        this.currentGame = currentGame;
        this.currentIncomes = currentIncomes;
        this.streamingTime = streamingTime;
        this.averageViewers = averageViewers;
    }
    public Streamer(int currentFollowers, int currentSubscribers) {
        this.currentFollowers = currentFollowers;
        this.currentSubscribers = currentSubscribers;
    }

    public boolean startStreaming(){
        return true;
    }

    public boolean endStreaming(){
        return true;
    }

    public boolean getFollower(){
        this.currentFollowers++;
        System.out.println("You have a new follower! Your current followers are: "+ this.currentFollowers);
        return true;
    }

    public boolean getSubscriber(){
        this.currentSubscribers++;
        System.out.println("CONGRATULATIONS! You have a new subscriber :) Your current subscribers are: "+ this.currentSubscribers);
        return true;
    }

    public String updateGame(){
        return "The game you are playing now is: " + this.currentGame;
    }

    public void getIncomes(){
        if ((this.streamingTime > 8) & (this.currentFollowers >50) & (this.averageViewers > 3)){
            this.currentIncomes++;
        }
        System.out.println("You still don't meet the requirements to monetize the channel, continue working. CHEER UP");
    }

    public String getName(){
        return name;
    }

    public List<Follower> getFollowers(){
        return followers;
    }

    public List<Subscriber> getSubscribers(){
        return subscribers;
    }
}
