import java.util.*;
import java.awt.Color;

public class Circle
{
    private int x;
    private int y;
    private int radius;
    private Color color;
    private int dx;
    private int dy;

    public Circle(int x, int y, int radius, Color color)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public Circle(int x, int y, int radius, Color color, int dx, int dy)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.dx = dx;
        this.dy = dy;
    }

    public void setXY() {
        Random rng = new Random();
        this.dx = rng.nextInt(5) + 1;
        this.dy = rng.nextInt(5) + 1;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }

    public void update() {
        bounce();
        this.x += this.dx;
        this.y += this.dy;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);
    }

    public boolean overlaps(Circle other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        if (distance < (this.radius + other.radius)) {
            return true;
        }
        return false;
    }

    public boolean overlaps(ArrayList<Circle> circles) {
        for (Circle other : circles) {
            double dx = this.x - other.x;
            double dy = this.y - other.y;
            double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            if (distance < (this.radius + other.radius)) {
                return true;
            }
        }
        return false;
    }

    public void bounce() {
        if (600 - x - dx <= radius || radius >= x + dx) {
            dx *= -1;
        }
        if (600 - y - dy <= radius || radius >= y + dy) {
            dy *= -1;
        }
    }
    
    public boolean isPressed(double mouseX, double mouseY) {
        if (Math.abs(this.x - mouseX) <= radius && Math.abs(this.y - mouseY) <= radius) {
            return true;
        }
        return false;
    }
}