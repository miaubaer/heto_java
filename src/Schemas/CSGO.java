package Schemas;

import java.util.Hashtable;

import javax.net.ssl.SSLEngineResult.HandshakeStatus;

public class CSGO extends Game {
    private final int ROUNDS = 30;
    private final String[] MAPS = {
        "Inferno",
        "Train",
        "Mirage",
        "Nuke",
        "Overpass",
        "Dust II",
        "Vertigo"
    };

    private String chosenMap;
    private int currentRound;
    private Team ct;
    private Team t;
    // [CT, T]
    private int[] scores = new int[2];
    private Team winner; 

    public CSGO(String map, Team ct, Team t) {
        this.chosenMap = map;
        this.currentRound = 1;
        this.ct = ct;
        this.t = t;
        this.scores[0] = 0;
        this.scores[1] = 0;
    }

    @Override
    void displayGameInfo() {
        // TODO Auto-generated method stub

    }

    public void roundPlayed(String winner) {
        int ind;
        if (winner.toLowerCase() == "ct") {
            ind = 0;
        } else if (winner.toLowerCase() == "ct") {
            ind = 1;
        } else { return; }

        this.currentRound++;
        this.scores[ind]++;

        if (currentRound == 15) {
            // change sides
        }

        if (scores[0] == 16) {
            this.winner = ct;
        } else if (scores[1] == 16) {
            this.winner = t;
        }
    }

    public Team getWinner() {
        return winner;
    }
}