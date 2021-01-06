package Schemas;

import java.util.ArrayList;
import java.util.List;


public class Team {

    private String teamName;
    // private int totalWins;
    // private int ranking;
    private String[] playerList; // marker evtl Schemas.Game List

    // Konstruktor
    public Team(String teamName, String[] playerList) {
        this.teamName = teamName;
        this.playerList = playerList;
    }
    
    public String getTeamName() {
        return teamName;
    }

    public String[] getPlayerList() {
        return playerList;
    }
}
