import java.util.*;

public class Lock {
    public boolean locked;
    
    public Lock() {
        this.locked = true;
    }
    
    public void open() {
        locked = false;
    }
    
    public void close() {
        locked = true;
    }
    
    public boolean isLocked() {
        return locked;
    }
    
    public String toString() {
        if (locked == true) {
            return "Lock is closed";
        }
        return "Lock is open";
    }
}