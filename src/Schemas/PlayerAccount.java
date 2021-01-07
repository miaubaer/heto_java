package Schemas;

public class PlayerAccount {

    private String nick;
    private String teamID;
    private double netWorth;
    private int totalKills;
    private int deaths;


    //Methods

    // showPlayerAccountInfo
    public double determineKillDeathRate()
    {
        return totalKills/deaths;
    }

    // Getter & Setter

}
