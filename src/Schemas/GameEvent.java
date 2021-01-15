package Schemas;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class GameEvent {
    private String GameEventName; 
    private String GameEventLocation;
    private double prizepool;
    private double[] ratio;
    private Team[] places;
    private List<Team> teamList;
    private List<Game> gameList;

    public GameEvent(String GameEventName, String GameEventLocation, double prizepool, double[] ratio, List<Team> teams) {
        this.GameEventName = GameEventName;
        this.GameEventLocation = GameEventLocation;
        this.prizepool = prizepool;
        
        teamList = new ArrayList<Team>();
        // set ratio muss ausgeführt werden, wenn eine Liste zur Variable teamList bereits zugewiesen ist.
        this.setRatio(ratio);

        gameList = new ArrayList<Game>();
    }


    // Getter & Setter (in one-line-format for a better overview)

    public String getGameEventName() { return GameEventName; }
    public void setGameEventName(String GameEventName) { this.GameEventName = GameEventName; }

    public String getGameEventLocation() { return GameEventLocation; }
    public void setGameEventLocation(String GameEventLocation) { this.GameEventLocation = GameEventLocation; }

    // von Hermann
    public double getPrizepool() { return this.prizepool; }
    public void setPrizepool(double prizepool) { this.prizepool = prizepool; }


    public List<Game> getGameList() { return gameList; }
    public void setGameList(List<Game> gameList) { this.gameList = gameList; }

    public String getRatio() {
        String res = "";
        for (double e : this.ratio) {
            res += e;
        }
        return res; 
    }

    // Variable in meinem Code war gleich der Variable teamList in deinem Code. (Hermann)
    public void setRatio(double[] ratio) {

        // HINZUFÜGEN: Prüfung ob angegebene Ratio vom Prizepool gleich 1 ist. Fallst nicht, Exception ausspucken. (Hermann)

        double[] res = new double[teamList.size()];
        for (int i = 0; i < teamList.size(); i++) {
            if (ratio.length < i) {
                res[i] = ratio[i];
            } else {
                res[i] = 0;
            }
        }
        this.ratio = res;
    }

    public void insert(Connection con) {
        //Das GameEvent der SQL-Datenbank hinzufügen.
        String query = "INSERT into GameEvent (id,location,inventory) values (?,?,?)";
        PreparedStatement pstmt= null;

        try {
            pstmt= con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(GameEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmt.setString(1, this.GameEventName);
            pstmt.setString(2, this.GameEventLocation);
            /*MARKER14 Inventory            pstmt.setString(3, String.valueOf(this.GameEventInventory.getID()));*/
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GameEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void select(Connection con) {
        //GameEvent und games der SQL-Datenbank hinzufügen.
        String query= "select * from GameEventGames where GameEventID="+ "'" + this.GameEventName + "'";
        PreparedStatement pstmt= null;

        // Diesen Teil des Codes sollen wir besprechen (Hermann)
        boolean flag = false; 
        try {
            pstmt= con.prepareStatement(query);
            ResultSet set= pstmt.executeQuery();
            if (set.next())
            {
                String a= set.getString("GameEventID");
                String b= set.getString("gameID");
                if (a.equalsIgnoreCase(this.GameEventName) && b.equalsIgnoreCase("Dota"))
                {
                    flag=true;  
                }
                else if (a.equalsIgnoreCase(this.GameEventName) && b.equalsIgnoreCase("CSGO"))
                {
                    flag=true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
