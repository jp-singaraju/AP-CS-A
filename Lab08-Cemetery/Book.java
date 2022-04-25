import java.util.*;

public class Book
{
    private String title;
    private String author;
    private double price;
    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public String toString() {
        return this.title + ", by " + this.author + ". Cost: $" + this.price; 
    }

    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public double getPrice() {
        return this.price;
    }
}
