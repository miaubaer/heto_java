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


    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalWins() {
        return this.totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getRanking() {
        return this.ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
    
}
