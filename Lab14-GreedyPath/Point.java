import java.util.*;

public class Point {
    private double x, y;
    private boolean visited;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.visited = false;
    }
    
    /** get the Euclidean distance between two points */
    public double getDistance(Point other) {
        double sqX = Math.pow((other.x - this.x), 2);
        double sqY = Math.pow((other.y - this.y), 2);
        return Math.sqrt(sqX + sqY);
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public boolean getVisited() {
        return this.visited;
    }
    
    public void setVisited(boolean hasVisited) {
        this.visited = hasVisited;
    }

    @Override
    public String toString() {
        return "x: " + this.x + ", y: " + this.y + ", visited: " + this.visited;
    }
}
