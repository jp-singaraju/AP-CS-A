import java.io.*;
import java.util.*;

public class GreedyPath extends Path {
    private Point[] greedyPoints;

    public GreedyPath(String fileName) throws FileNotFoundException {
        super(fileName);
        greedyPoints = new Point[getNumPoints()];
        greedyPoints[0] = super.getPoint(0);
        greedyPoints[0].setVisited(true);
        findPath();
    }

    public void findPath() {
        for (int i = 0; i < greedyPoints.length - 1; i++) {
            double close = Integer.MAX_VALUE;
            for (int j = 0; j < greedyPoints.length; j++) {
                if (super.getPoint(j).getVisited() == false) {
                    double distance = greedyPoints[i].getDistance(super.getPoint(j));
                    if (distance < close) {
                        close = distance;
                    }
                }
            }
            for (int k = 0; k < greedyPoints.length; k++) {
                if (super.getPoint(k).getVisited() == false) {
                    double distance = greedyPoints[i].getDistance(super.getPoint(k));
                    if (distance == close) {
                        greedyPoints[i + 1] = super.getPoint(k);
                        super.getPoint(k).setVisited(true);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public double getDistance() {
        double total = 0;
        for (int index = 0; index < greedyPoints.length - 1; index++) {
            total += greedyPoints[index].getDistance(greedyPoints[index + 1]);
        }
        return total;
    }

    @Override
    public Point getPoint(int index) {
        return greedyPoints[index]; 
    }

    @Override
    public String toString() {
        return Arrays.toString(greedyPoints);
    }
}
