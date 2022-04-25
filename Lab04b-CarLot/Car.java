import java.util.*;

public class Car {
    private int fuelCap;
    private int fuelEff;
    private int currMileage;
    private double currFuelLvl;
    private String name;
    
    public Car(String carName, int cap, int eff, int mileage) {
        name = carName;
        fuelCap = cap;
        fuelEff = eff;
        currMileage = mileage;
        currFuelLvl = (double) cap / 2;
        if (fuelCap < 0) {
            throw new IllegalArgumentException("the tank capacity argument is illegal");
        }
        if (fuelEff < 0) {
            throw new IllegalArgumentException("the fuel efficiency argument is illegal");
        }
        if (currMileage < 0) {
            throw new IllegalArgumentException("the current mileage argument is illegal");
        }
        if (currFuelLvl < 0) {
            throw new IllegalArgumentException("the current fuel level argument is illegal");
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getCap() {
        return fuelCap;
    }
    
    public int getEff() {
        return fuelEff;
    }
    
    public int getMileage() {
        return currMileage;
    }
    
    public double getFuelLvl() {
        return currFuelLvl;
    }
    
    public void drive(int numMiles) {
        double compareMiles = (double)currFuelLvl * fuelEff;
        currFuelLvl -= ((double)1/fuelEff) * numMiles;
        currMileage += numMiles;
        if (numMiles > compareMiles) {
            throw new IllegalArgumentException("distance is too far");
        }
    }
    
    public void addGas(double gallons) {
        currFuelLvl += gallons;
        if (currFuelLvl > fuelCap) {
            throw new IllegalArgumentException("exceeds fuel capacity");
        }
    }
    
    public String toString() {
        return String.format("%-20s %14d %6d %12.1f %9d", name, fuelCap, fuelEff, currFuelLvl, currMileage);
    }    
}
