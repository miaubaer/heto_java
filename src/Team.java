package esportsmanagement;

import java.util.ArrayList;
import java.util.List;


public class Team {

    private String teamName;
    private int totalWins;
    private int ranking;
    private List<Player> playerList; // marker evtl Game List

    // Konstruktor
    public Team(String teamName, int totalWins, int ranking, List<Player> playerList) {
        this.teamName = teamName;
        this.playerList = playerList;
        this.totalWins = totalWins;
        this.ranking = ranking;
        playerList= new ArrayList<Player>();
    }

    // Methods

    // Methode: Zeige Team (mit graphisches Interface)
    // Methode: AddPlayerToList
    // marker evtl AddGameToList


    // Getter & Setter


}
