package Schemas;

public class Dota extends Game {
    // As an example: defeated towers [left, right]
    private int[] scores = new int[2];
    private Team throneDefeated;

    // each team choose 5 heroes
    // private String[][] = new String[2][5];

    public Dota(int id, Team[] teams) {
        super(id, teams);
    }
    
    public Dota(int id, Team[] teams, String duration, Team throneDefeated, int[] scores) {
        super(id, teams);

        this.throneDefeated = throneDefeated;
        this.scores = scores;
    }


    public Team getLeft() { return this.teams[0]; }

    public Team getRight() { return this.teams[1]; }

    public int[] getScores() { return this.scores; }

    public void setWinner(Team throneDefeated, int[] scores) {
        this.throneDefeated = throneDefeated;
        this.scores = scores;
    }
    @Override
    Team getWinner() { return this.throneDefeated; }
}
