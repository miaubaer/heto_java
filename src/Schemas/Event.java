package Schemas;

import java.sql.*;
import java.util.*;

public class Event {
    private String name;
    private String location;
    private double prizepool;
    private double[] ratio;
    private Team[] places;

    private List<Team> team;
    private List<Game> game;
    // private List<Sponsor> sponsorList;



    // private List<Spectator> audience;
    // private Inventory eventInventory;
    // private double eventCost;
    // private double sponsorRevenue;
    // Scanner in= new Scanner(System.in);
    // Connection con;

    public Event(String name, String location, double prizepool, double[] ratio, List<Team> team) {
        setName(name);
        setLocation(location);
        setPrizepool(prizepool);
        setTeam(team);
        setRatio(ratio);
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
