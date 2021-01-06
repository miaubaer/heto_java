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
    private List<Spectator> audience;
    private List<Sponsor> sponsorList;
    // private Inventory eventInventory;
    // private double eventCost;
    // private double sponsorRevenue;
    // Scanner in= new Scanner(System.in);
    // Connection con;

    public Event(String eventName, String eventLocation) throws ClassNotFoundException {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.prizepool = prizepool;
        this.ratio = ratio;
        this.places = places;
        // Array Listen innerhalb des Konstruktors mussten wie folgt verändert werden. Quelle: https://stackoverflow.com/questions/22736092/declaring-arraylist-in-java-constructor
        teamList = new ArrayList<Team>();
        gameList = new ArrayList<Game>();
        audience = new ArrayList<Spectator>();
        sponsorList = new ArrayList<Sponsor>();
        /* Sicherung
        this.teamList = teamList; this.gameList = gameList; this.audience = audience; this.sponsorList = sponsorList;*/
        con = ConnectionProvider.getConnection();

        //Das event der SQL-Datenbank hinzufügen.
        query= "INSERT into Event (id,location,inventory) values (?,?,?)";
        try {
            pstmt= con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmt.setString(1, this.eventName);
            pstmt.setString(2, this.eventLocation);
            pstmt.setString(3, String.valueOf(this.eventInventory.getID()));
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean flag=false;

        //event und games der SQL-Datenbank hinzufügen.
        query= "select * from EventGames where eventID="+ "'" + this.eventName + "'";
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrizepool() {
        return this.prizepool;
    }

    public void setPrizepool(double prizepool) {
        this.prizepool = prizepool;
    }

    public double[] getRatio() {
        return this.ratio;
    }

    public void setRatio(double[] ratio) {
        double[] res = new double[team.size()];
        for (int i = 0; i < team.size(); i++) {
            if (ratio.length < i) {
                res[i] = ratio[i];
            } else {
                res[i] = 0;
            }
        }

        this.ratio = res;
    }

    public Team[] getPlaces() {
        return this.places;
    }

    public void setPlaces(Team[] places) {
        this.places = places;
    }

    public List<Team> getTeam() {
        return this.team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public List<Game> getGame() {
        return this.game;
    }

    public void setGame(List<Game> game) {
        this.game = game;
    }

}
