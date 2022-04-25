import java.util.*;

public class ShoppingCart {
    private ArrayList<ItemOrder> cart;
    private double total;
    private boolean isDiscounted;

    public ShoppingCart () {
        cart = new ArrayList<ItemOrder>();
    }

    public void add (ItemOrder order) {
        int index = 0;
        boolean needToAdd = true;
        while (index < cart.size() && needToAdd == true) {
            if (order.getItem() == cart.get(index).getItem()) {
                cart.set(index, order);
                needToAdd = false;
            }
            index++;
        }
        if (needToAdd == true) {
            cart.add(order);
        }
    }
    
    public void setDiscount (boolean isDiscount) {
        isDiscounted = isDiscount;
    }
    
    public double getTotal () {
        double total = 0;
        for (ItemOrder order : cart) {
            total += order.getPrice();
        }
        if (isDiscounted == true) {
            total *= .9;
        }
        return total;
    }
} 