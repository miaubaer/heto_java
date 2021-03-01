package Schemas;

public class CSGO extends Game {
    // first team is always starting on the counter-strike side
    // second team is always starting on the terrorist side
    // the sides will be swapped after first half of the game

    // The variables are showing starting positions of teams
    // scores: [team1: [ct, t], team2: [t, ct]]
    private int[][] scores = new int[2][2];

    public CSGO(int id, Team[] teams) {
        super(id, teams);
    }

    public CSGO(int id, Team[] teams, int[][] scores, int hours, int minutes) {
        super(id, teams);

        this.setWinner(scores, hours, minutes);
    }


    public Team getCounterStrike() { return this.teams[0]; }

    public Team getTerrorist() { return this.teams[1]; }

    public int[] getScores() {
        int[] res = {
            this.scores[0][0] + this.scores[1][0],
            this.scores[0][1] + this.scores[1][1]
        };

        return res;
    }

    public void setWinner(int[][] scores, int hours, int minutes) {
        this.scores = scores;
        this.setDuration(hours, minutes);
    }

    @Override
    Team getWinner() {
        if (this.scores == null) return null;

        int t1 = this.scores[0][0] + this.scores[1][0];
        int t2 = this.scores[0][1] + this.scores[1][1];

        // there must be a winner.
        if (t1 > t2) {
            return this.teams[0];
        } else {
            return this.teams[1];
        }
    }
}