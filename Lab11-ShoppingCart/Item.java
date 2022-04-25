import java.util.*;
import java.text.*;

public class Item {
    private String name;
    private double price;
    private int bulkQuantity;
    private double bulkPrice;
    private boolean hasBulkPrice;

    public Item (String name, double price) {
        this.name = name;
        throwError(price);
        this.price = price;
    }

    public Item (String name, double price, int bulkQuantity, double bulkPrice) {
        this.name = name;
        throwError(price);
        throwError(bulkQuantity);
        throwError(bulkPrice);
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
        hasBulkPrice = true;
    }

    public double priceFor (int quantity) {
        double temp = 0;
        double total = 0;
        if (hasBulkPrice) {
            temp = ((double) (quantity / bulkQuantity) * bulkPrice);
            total = ((quantity % bulkQuantity) * price) + temp;
        } else {
            total = quantity * price;
        }
        return total;
    }
    
    public String toString () {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String price1 = nf.format(this.price);
        String bulkPrice1 = nf.format(this.bulkPrice);
        String str = name  + ", " + price1;
        if (hasBulkPrice) {
            str += (" " + "(" + bulkQuantity + " for " + bulkPrice1 + ")");
        }
        return str;
    }

    private void throwError (double value) {
        if (value < 0) {
            throw new IllegalArgumentException("value cannot be negative");
        }
    }
}