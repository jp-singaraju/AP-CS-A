import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;


public class Path {
    private Point[] points;
    private double minX, minY;
    private double maxX, maxY;

    /** construct a path from a given file */
    public Path(String fileName) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(fileName));
        points = new Point[(int) reader.nextDouble()];
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            Point point = new Point(reader.nextDouble(), reader.nextDouble());
            points[index] = point;
            index++;
        }
        for (Point point : points) {
            if (point.getX() < this.minX) {
                this.minX = point.getX();
            }
            if (point.getX() > this.maxX) {
                this.maxX = point.getX();
            }
            if (point.getY() < this.minY) {
                this.minY = point.getY();
            }
            if (point.getY() > this.maxY) {
                this.maxY = point.getY();
            }
        }
    }

    /** returns the distance traveled going point to point, in order given in file */
    public double getDistance() {
        double total = 0;
        for (int index = 0; index < points.length - 1; index++) {
            total += points[index].getDistance(points[index + 1]);
        }
        return total;
    }
    
    public Point getPoint(int index) {
       return points[index]; 
    }
    
    public double getMinX() {
        return this.minX;
    }
    
    public double getMinY() {
        return this.minY;
    }
    
    public double getMaxX() {
        return this.maxX;
    }
    
    public double getMaxY() {
        return this.maxY;
    }
    
    public int getNumPoints() {
        return this.points.length;
    }

    @Override
    public String toString() {
        return "minX: " + this.minX + ", minY: " + this.minY + ", maxX: " + this.maxX + ", maxY: " + this.maxY;
    }
}
