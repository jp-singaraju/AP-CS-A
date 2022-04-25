import java.util.*;

public class ItemOrder {
    private Item item;
    private int quantity;
    
    public ItemOrder (Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    
    public double getPrice () {
        return item.priceFor(quantity);
    }
    
    public Item getItem () {
        return item;
    }
}