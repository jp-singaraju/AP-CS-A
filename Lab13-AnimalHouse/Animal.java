import java.util.*;

public class Animal {
    private String name;
    private int birthyear;
    private Animal friend;
    private ArrayList<Toy> toys;
    static int currentYear;
    
    public Animal(String name, int birthyear) {
        this.name = name;
        this.birthyear = birthyear;
        this.friend = null;
        this.currentYear = 2021;
        toys = new ArrayList<Toy> ();
    }
    
    public void setFriend(Animal animal) {
        this.friend = animal;
    }
    
    public void addToy(Toy toy) {
        toys.add(toy);
    }
    
    public int getAge() {
        return currentYear - this.birthyear;
    }
    
    public ArrayList<Toy> getToys() {
        return this.toys;
    }
    
    public String toString() {
        String str = "Hello, I am " + this.name + ". I am " + getAge() + " years old.\n";
        if (friend != null) {
            str += "I have a friend named " + friend.name + ".\n";
        } else {
            str += "I have no friends.\n";
        }
        str += "I have the following toys: " + toys.toString() + "\n";
        return str;
    }
}