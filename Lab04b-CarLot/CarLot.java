import java.util.*;
import java.io.*;

public class CarLot
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Scanner reader = new Scanner(new File("cars2.txt"));

        int length = reader.nextInt();
        Car[] cars = new Car[length];

        for (int index = 0; index < cars.length; index++) {
            reader.nextLine();
            String name = reader.nextLine();
            cars[index] = new Car(name, reader.nextInt(), reader.nextInt(), reader.nextInt());
        }

        String selection = "";

        while (!selection.equals("Q")) {
            System.out.println();
            print(cars);
            System.out.println();
            System.out.print("Do you want to (D)rive, (A)dd gas, or (Q)uit? ");
            selection = scanner.nextLine();
            if (selection.equals("D")) {
                System.out.print("Which car (1-4)? ");
                int carNum = scanner.nextInt();
                System.out.print("How many miles? ");
                int numMiles = scanner.nextInt();
                if (numMiles < 0) {
                    throw new IllegalArgumentException("miles to drive must be greater than 0");
                }
                cars[carNum - 1].drive(numMiles);
            } else if (selection.equals("A")) {
                System.out.print("Which car (1-4)? ");
                int carNum = scanner.nextInt();
                System.out.print("How much gas? ");
                double numGals = scanner.nextDouble();
                if (numGals < 0) {
                    throw new IllegalArgumentException("gas amount to add must be greater than 0");
                }
                cars[carNum - 1].addGas(numGals);
            }
            scanner.nextLine();
        }
    }

    public static void print(Car[] cars) {
        System.out.printf("%-23s %14s %6s %12s %9s\n", "   Car Name", "Fuel Capacity", "MPG", "Fuel Level", "Mileage");
        for (int index = 0; index < cars.length; index++) {
            System.out.println((index + 1) + ": " + cars[index].toString());
            System.out.println();
        }
    }
}
