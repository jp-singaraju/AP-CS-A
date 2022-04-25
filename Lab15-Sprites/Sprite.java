import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;

public abstract class Sprite {
    private double x; //the x-coordinate of the center of the sprite
    private double y; //the y-coordinate of the center of the sprite
    private int width; //width of the sprite (for drawing)
    private int height; //height of the sprite (for drawing)
    private String image; //filename of the sprite's image

    public Sprite(double x, double y, int width, int height, String image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setImage(image);
    }

    public void draw() {
        //draw based on sprite's size, so you don't have to manually scale images
        StdDraw.picture(this.getX(), this.getY(), this.getImage(), this.width, this.height);
    }

    public boolean overlap(Sprite other) {
        if ((this.x < other.x) && (this.x + (this.width / 2) > other.x - (other.width / 2))) {
            if ((this.y < other.y) && (this.y + (this.height / 2) > other.y - (other.height / 2))) {
                return true;
            } else if ((other.y < this.y) && (other.y + (other.height / 2) > this.y - (this.height / 2))) {
                return true;
            }
            else {
                return false;
            }
        }
        else if ((other.x < this.x) && (other.x + (other.width / 2) > this.x - (this.width / 2))) {
            if ((this.y < other.y) && (this.y + (this.height / 2) > other.y - (other.height / 2))) {
                return true;
            } else if ((other.y < this.y) && (other.y + (other.height / 2) > this.y - (this.height / 2))) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public abstract void step(World world);

    public double getX() {
        return this.x;     
    }

    public int getWidth() {
        return this.width;
    }

    public double getY() {
        return this.y;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImage() {
        return this.image;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
