import java.util.*;

public class Catalog {
    private String name;
    private ArrayList<Item> catalog;
    
    public Catalog (String name) {
        catalog = new ArrayList<Item>();
        this.name = name;
    }
    
    public void add (Item item) {
        catalog.add(item);
    }
    
    public int size () {
        return catalog.size();
    }
    
    public Item get (int index) {
        return catalog.get(index);
    }
    
    public String getName () {
        return name;
    }
}