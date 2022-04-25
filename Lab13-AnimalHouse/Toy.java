import java.util.*;

public class Toy {
    private String name;
    
    public Toy(String name) {
        this.name = name;
    }
    
    public String toString() {
        return "A " + this.name;
    }
    
    @Override
    public boolean equals(Object obj) {
        Toy alt = (Toy) obj;
        if (this.name.equals(alt.name)) {
            return true;
        }
        return false;
    }
}