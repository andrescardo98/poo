package com.andres.soccerPlayer.app;

import com.andres.soccerPlayer.domain.SoccerPlayer;

public class SoccerPlayerApp {
    public static void main(String[] args) {
        SoccerPlayer player = new SoccerPlayer();
        player.name = "Cristiano";
        player.lastName = "Ronaldo";
        player.timePlayed = 88;

        player.scoring(3);
        player.passing(27);
        player.running(5.40);

        System.out.println(player.getScoredGoals());
    }
}
