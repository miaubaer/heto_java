package Schemas;

import java.util.Date;

public class Mouse extends Inventory {
    private int dpi;
    private int programmableButtons;
    private String connectionType;
    private int responseRate;


    public Mouse(int id, Date bought, int price, String brand, String model, int dpi, int programmableButtons, String connectionType, int responseRate) {
        super(id, bought, price, brand, model);
        this.dpi = dpi;
        this.programmableButtons = programmableButtons;
        this.connectionType = connectionType;
        this.responseRate = responseRate;
    }


    public int getDpi() {
        return this.dpi;
    }

    public int getProgrammableButtons() {
        return this.programmableButtons;
    }

    public String getConnectionType() {
        return this.connectionType;
    }

    public int getResponseRate() {
        return this.responseRate;
    }
}
