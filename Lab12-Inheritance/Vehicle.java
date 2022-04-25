import java.util.*;

public class Vehicle {
    private String type;
    private int year;
    private double price;
    
    public Vehicle(String type, int year, double price) {
        this.type = type;
        this.year = year;
        this.price = price;
    }
    
    public String getInfo() {
        return type + " " + year;
    }
    
    public String getType() {
        return this.type;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public double getPrice() {
        return this.price;
    }
}