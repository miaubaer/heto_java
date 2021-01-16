package Schemas;

public class CSGO extends Game {

    private int currentRound;
    private Team ct;
    private Team t;
    // [CT, T]
    private int[] scores = new int[2];
    private Team winner; 

    public CSGO(String map, Team ct, Team t) {
        this.currentRound = 1;
        this.ct = ct;
        this.t = t;
        this.scores[0] = 0; // ct
        this.scores[1] = 0; // t
    }

    @Override
    void displayGameInfo() {

    }

    public void roundPlayed(String winner) {
        int ind;
        if (winner.toLowerCase() == "ct") {
            ind = 0;
        } else if (winner.toLowerCase() == "t") {
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