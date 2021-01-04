import java.util.Hashtable;

import javax.net.ssl.SSLEngineResult.HandshakeStatus;

public class CSGO extends Game implements PrizePoolInterface {
    private final int ROUNDS = 30;
    private final String[] MAPS = {
        "Inferno",
        "Train",
        "Mirage",
        "Nuke",
        "Overpass",
        "Dust II",
        "Vertigo"
    };

    private String chosenMap;
    private int currentRound;
    private Hashtable<Team, Integer> team = new Hashtable<Team, Integer>();
    private Hashtable<String, Team> sides = new Hashtable<String, Team>();
    private String[] history = new String[30];

    public CSGO() {
    }

    //Add-in BEGIN
    @Override
    public void displayGameInfo() {
        System.out.println("Counter Strike Global Offensive (GSGO) ist ein Computerspiel aus dem Genre der Online-Taktik-Shooter. Bei dem Spiel treten zwei Teams mit je fünf Spielern gegeneinander an. Wobei jedes Team bestimmte Ziele erreichen muss, um zu gewinnen. Ein Team übernimmt die Rolle der Terroristen (Ts), während das andere Team die Antiterroristen (CTs) sind.");
    }

    @Override
    public void setGamePrizePool() {
        this.setPrizepool(this.getAverageRevenue());
    }
    //Add-in END

    private void setPrizepool(Object averageRevenue) {
    }

    private Object getAverageRevenue() {
        return null;
    } 
}