import java.util.Date;

public class Monitor extends Inventory {
    private int size;
    private String resolution;
    private boolean twisted;
    private int refreshRate;


    public Monitor(int id, Date bought, int price, String brand, String model, int size, String resolution, boolean twisted, int refreshRate) {
        super(id, bought, price, brand, model);
        this.size = size;
        this.resolution = resolution;
        this.twisted = twisted;
        this.refreshRate = refreshRate;
    }


    public int getSize() {
        return this.size;
    }

    public String getResolution() {
        return this.resolution;
    }

    public boolean isTwisted() {
        return this.twisted;
    }

    public int getRefreshRate() {
        return this.refreshRate;
    }

}
