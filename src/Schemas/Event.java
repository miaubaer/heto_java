package Schemas;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class Event {
    private String eventName; 
    private String eventLocation;
    private double prizepool;
    private double[] ratio;
    private Team[] places;
    private List<Team> teamList;
    private List<Game> gameList;
    
    // private List<Spectator> audience;
    // private List<Sponsor> sponsorList;
    // private Inventory eventInventory;   //added for later
    // private double eventRevenue;
    // private double eventCost;
    // private double sponsorRevenue;

    public Event(String eventName, String eventLocation, double prizepool, double[] ratio, List<Team> teams) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.prizepool = prizepool;
        
        teamList = new ArrayList<Team>();
        // set ratio muss ausgeführt werden, wenn eine Liste zur Variable teamList bereits zugewiesen ist.
        this.setRatio(ratio);

        gameList = new ArrayList<Game>();
        // audience = new ArrayList<Spectator>();
        // sponsorList = new ArrayList<Sponsor>();
        // eventRevenue = 0;

        // !!! WICHTIG !!!

        // Ich schiebe der DB bezüglichen Methoden in die gertennte Methode.
        // Es ist nicht nötig im Constructor, jedoch wird als eine Methode der Instanz gebraucht.
        // Wenn es so ist, brauchen wir keinen Attribut für Connection newschreiben. Die Methoden können es als Argument nehmen.

        // Eigentlich hier können wir eine Schnittstelle schreiben, die Methoden für die Datenleitung erhalten wird.
        
        // --- --- --- ---
    }


    // Getter & Setter (in one-line-format for a better overview)

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getEventLocation() { return eventLocation; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    // von Hermann
    public double getPrizepool() { return this.prizepool; }
    public void setPrizepool(double prizepool) { this.prizepool = prizepool; }


    public List<Game> getGameList() { return gameList; }
    public void setGameList(List<Game> gameList) { this.gameList = gameList; }

    public double[] getRatio() { return this.ratio; }

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
        //Das Event der SQL-Datenbank hinzufügen.
        String query = "INSERT into Event (id,location,inventory) values (?,?,?)";
        PreparedStatement pstmt= null;

        try {
            pstmt= con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmt.setString(1, this.eventName);
            pstmt.setString(2, this.eventLocation);
            /*MARKER14 Inventory            pstmt.setString(3, String.valueOf(this.eventInventory.getID()));*/
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void select(Connection con) {
        //event und games der SQL-Datenbank hinzufügen.
        String query= "select * from EventGames where eventID="+ "'" + this.eventName + "'";
        PreparedStatement pstmt= null;

        // Diesen Teil des Codes sollen wir besprechen (Hermann)
        boolean flag = false; 
        try {
            pstmt= con.prepareStatement(query);
            ResultSet set= pstmt.executeQuery();
            if (set.next())
            {
                String a= set.getString("eventID");
                String b= set.getString("gameID");
                if (a.equalsIgnoreCase(this.eventName) && b.equalsIgnoreCase("Dota"))
                {
                    flag=true;  
                }
                else if (a.equalsIgnoreCase(this.eventName) && b.equalsIgnoreCase("CSGO"))
                {
                    flag=true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
