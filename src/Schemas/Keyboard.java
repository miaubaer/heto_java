package Schemas;

import java.util.Date;

public class Keyboard extends Inventory {
    
    private boolean mechanical;
    private String type;
    private int programmableButtons;
    private String connectionType;
    private int responseRate;
    
    public Keyboard(int id, Date bought, int price, String brand, String model, boolean mechanical, String type, int programmableButtons, String connectionType, int responseRate) {
        super(id, bought, price, brand, model);
        this.mechanical = mechanical;
        this.type = type;
        this.programmableButtons = programmableButtons;
        this.connectionType = connectionType;
        this.responseRate = responseRate;
    }

    public boolean isMechanical() {
        return this.mechanical;
    }

    public String getType() {
        return this.type;
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
