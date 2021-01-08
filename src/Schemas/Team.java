package Schemas;

public class Team {
    private String teamName;
    // private int ranking;
    private String[] playerList; // marker evtl Game List

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
