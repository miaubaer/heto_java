package Schemas;

abstract class Game {
    protected int id;
    protected Team[] teams = new Team[2];
    // hh:mm
    protected String duration;

    public Game(int id, Team[] teams) {
        this.id = id;
        this.teams = teams;
    }
    
    public int getId() { return this.id; }

    public String getDuration() { return this.duration; }
    public void setDuration(int hours, int minutes) {
        this.duration = String.format("%d:%d", hours, minutes);
    }

    abstract Team getWinner();
}