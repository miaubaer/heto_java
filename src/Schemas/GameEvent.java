package Schemas;

import java.util.Arrays;
import java.util.Date;

public class GameEvent {
    public static final String[] columns = {
        "id",
        "name", 
        "location", 
        "prizepool",
        "ratio",
        "start_date",
        "end_date"
    };
    public static final String table = "GameEvent";

    private int id;
    private String name;
    private String location;
    private int prizepool;
    private double[] ratio;
    private Date start;
    private Date end;

    public GameEvent(String name, String location, int prizepool, String ratio, Date start, Date end) {
        this.name = name;
        this.location = location;
        this.prizepool = prizepool;
        this.start = start;
        this.end = end;

        this.setRatio(ratio);
    }

    public GameEvent(int id, String name, String location, int prizepool, String ratio, Date start, Date end) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.prizepool = prizepool;
        this.start = start;
        this.end = end;

        this.setRatio(ratio);
    }

    // Getter & Setter (in one-line-format for a better overview)

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public int getPrizepool() { return this.prizepool; }

    public void setPrizepool(int prizepool) { this.prizepool = prizepool; }

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

    public void setRatio(String ratioString) {
        this.ratio = Arrays.stream(ratioString.split(", ")).map(String::trim).mapToDouble(Double::parseDouble)
                .toArray();
    }
}
