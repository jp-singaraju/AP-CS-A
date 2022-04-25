import java.util.*;

public class House {
    private ArrayList<Animal> house;

    public House() {
        house = new ArrayList<Animal> ();
    }
    
    public void add(Animal animal) {
        house.add(animal);
    }

    public void printAnimals() {
        for (Animal animal : house) {
            System.out.println(animal.toString());
        }
    }

    public void cleanHouse() {
        for (Animal a : house) {
            ArrayList<Toy> toys = a.getToys();
            for (int i = 0; i < toys.size(); i++) {
                if (toys.lastIndexOf(toys.get(i)) != i) {
                    toys.remove(i);
                    i--;
                }
            }
        }
    }
}