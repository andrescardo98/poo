package com.andres.soccerPlayer.app;

import com.andres.soccerPlayer.domain.SoccerPlayer;

public class SoccerPlayerApp {
    public static void main(String[] args) {
        SoccerPlayer player = new SoccerPlayer("Cristiano", "Ronaldo", "Al Nassar");
        SoccerPlayer player2 = new SoccerPlayer("Kylian","Mbappé",(byte)24,"French","PSG","Winger");


        player.scoring(3);
        player.passing(27);
        player.running(5.40);
        player.quiting(7);
        player.countingTime(93);

        player2.passing(24);
        player2.scoring(4);
        player2.running(7.21);
        player2.quiting(4);
        player2.countingTime(91);

        System.out.println(player.getScoredGoals());
        System.out.println(player2.getScoredGoals());
    }
}
