package com.andres.twitch.app;

import com.andres.twitch.domain.Follower;

public class TwitchApp {
    public static void main(String[] args) {
        Follower pedro = new Follower(4,true,"Westcol");

        System.out.println(pedro.searchStreamer());
    }
}
