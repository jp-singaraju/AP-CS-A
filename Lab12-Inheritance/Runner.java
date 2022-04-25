import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Vehicle car1 = new Car("Honda Pilot", 2018, 32751.56, 31);
        Vehicle car2 = new Car("Nissan Altima", 2020, 25623.89, 25);
        Vehicle truck1 = new Truck("Ford F-150", 2021, 33826.12, 3270);
        Vehicle truck2 = new Truck("Chevrolet Colorado", 2016, 27254.64, 2830);
        Vehicle mc1 = new Motorcycle("Ducati Streetfighter V4", 2020, 62957.39, 52.4);
        Vehicle mc2 = new Motorcycle("Harley-Davidson Bronx", 2021, 52234.15, 54.5);

        Inventory list = new Inventory();
        list.addVehicle(car1);
        list.addVehicle(car2);
        list.addVehicle(truck1);
        list.addVehicle(truck2);
        list.addVehicle(mc1);
        list.addVehicle(mc2);
        
        list.listInventory();
    }
}
