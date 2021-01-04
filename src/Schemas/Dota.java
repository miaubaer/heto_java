package Schemas;

import java.util.Objects;

public class Dota extends Game implements PrizePoolInterface {
    // check: https://dota2.gamepedia.com/Buildings#Outposts

    // FROM Generate All Quick
    public Dota() {

    }

    //Add-in BEGIN
    @Override
    public void displayGameInfo() {
        System.out.println("DotA 2 (Defence of the Ancients) ist ein Computerspiel aus dem Genre der MOBA. Bei dem Spiel treten zwei Teams mit je fünf Spielern gegeneinander an. Wobei jedes Team das eigene Ancient verteidigen muss um zu gewinnen. Ein Team übernimmt die Rolle der Dire , während das andere Team die Radiant sind.");
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
