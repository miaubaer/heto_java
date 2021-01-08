// Hermann

package Schemas;

import java.util.Date;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class Inventory {
    protected int id;
    protected Date bought;
    protected int price;
    protected String brand;
    protected String model;

    //Nachfolgende von Tobi (Bitte NICHT löschen)
    private int ID;
    private int headPhoneCount;
    private int computersCount;
    private int monitorsCount;
    private int mouseCount;
    private int keyboardCount;
    private int foodCapacity;
    private int frontRowSeats;
    private int backRowSeats;
    private int VIPRooms;
    private double inventoryCost=0;
    Random rand= new Random();
    Connection con;
    private boolean available;

    // Nachfolgende von Hermann
    public Inventory(int id, Date bought, int price, String brand, String model) {
        this.id = id;
        this.bought = bought;
        this.price = price;
        this.brand = brand;
        this.model = model;
        
        this.available = true;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBought() {
        return this.bought;
    }

    public void setBought(Date bought) {
        this.bought = bought;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Inventory id(int id) {
        this.id = id;
        return this;
    }

    public Inventory bought(Date bought) {
        this.bought = bought;
        return this;
    }

    public Inventory price(int price) {
        this.price = price;
        return this;
    }

    public Inventory brand(String brand) {
        this.brand = brand;
        return this;
    }

    public Inventory model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Inventory)) {
            return false;
        }
        Inventory inventory = (Inventory) o;
        return id == inventory.id && Objects.equals(bought, inventory.bought) && price == inventory.price && Objects.equals(brand, inventory.brand) && Objects.equals(model, inventory.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bought, price, brand, model);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", bought='" + getBought() + "'" +
            ", price='" + getPrice() + "'" +
            ", brand='" + getBrand() + "'" +
            ", model='" + getModel() + "'" +
            "}";
    }

    protected boolean isAvailable() {
        return this.available;
    }

    protected void toggleAvailability() {
        this.available = !this.available;
    }
}
