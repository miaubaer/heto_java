package Schemas;

import java.util.Date;

public class Headphones extends Inventory {
    private boolean anc;
    private boolean sorroundSound;
    private boolean mic;

    public Headphones(int id, Date bought, int price, String brand, String model, boolean anc, boolean sorroundSound, boolean mic) {
        super(id, bought, price, brand, model);
        this.anc = anc;
        this.sorroundSound = sorroundSound;
        this.mic = mic;
    }

    public boolean hasAnc() {
        return this.anc;
    }

    public boolean hasSorroundSound() {
        return this.sorroundSound;
    }

    public boolean mic() {
        return this.mic;
    }

    public boolean hasMic() {
        return this.mic;
    }

}
