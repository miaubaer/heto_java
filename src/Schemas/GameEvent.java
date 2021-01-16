package Schemas;

import java.util.Date;

public class GameEvent {
    private String GameEventName; 
    private String GameEventLocation;
    private double prizepool;
    private double[] ratio;
    private Date start;
    private Date end;
    // private Team[] places;
    // private List<Team> teamList;
    // private List<Game> gameList;

    public GameEvent(String GameEventName, String GameEventLocation, double prizepool, double[] ratio, Date start, Date end) {
        this.GameEventName = GameEventName;
        this.GameEventLocation = GameEventLocation;
        this.prizepool = prizepool;
        this.start = start;
        this.end = end;
        
        this.setRatio(ratio);
    }


    // Getter & Setter (in one-line-format for a better overview)

    public String getGameEventName() { return GameEventName; }
    public void setGameEventName(String GameEventName) { this.GameEventName = GameEventName; }

    public String getGameEventLocation() { return GameEventLocation; }
    public void setGameEventLocation(String GameEventLocation) { this.GameEventLocation = GameEventLocation; }

    // von Hermann
    public double getPrizepool() { return this.prizepool; }
    public void setPrizepool(double prizepool) { this.prizepool = prizepool; }

    public Date getStartDate() { return this.start; }
    public void setStartDate(Date startDate) { this.start = startDate; }

    public Date getEndDate() { return this.end; }
    public void setEndDate(Date endDate) { this.end = endDate; }

    public String getRatio() {
        String res = "";
        for (double e : this.ratio) {
            res = res + String.valueOf(e) + ", ";
        }
        return res.substring(0, res.length() - 2); 
    }

    // Variable in meinem Code war gleich der Variable teamList in deinem Code. (Hermann)
    public void setRatio(double[] ratio) {

        // HINZUFÜGEN: Prüfung ob angegebene Ratio vom Prizepool gleich 1 ist. Fallst nicht, Exception ausspucken. (Hermann)

        this.ratio = ratio;
    }
}
