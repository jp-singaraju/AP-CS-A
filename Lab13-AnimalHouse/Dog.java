import java.util.*;

public class Dog extends Animal {
    private boolean goodBoy;
    
    public Dog(String name, int birthYear, boolean goodBoy) {
        super(name, birthYear);
        this.goodBoy = goodBoy;
    }
    
    public String toString() {
        if (goodBoy == true) {
            return super.toString() + "I am a good boy.\n";
        }
        return super.toString() + "I am a bad boy.\n";
    }
}