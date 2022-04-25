import java.util.*;

public class Motorcycle extends Vehicle {
    private double height;
    
    public Motorcycle(String type, int year, double price, double height) {
        super(type, year, price);
        this.height = height;
    }
    
    public String getInfo() {
        return super.getInfo() + ", " + height + " inches tall, $" + getPrice();
    }
}