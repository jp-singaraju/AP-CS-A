import java.io.*;
import java.util.*;

public class MapTester
{
    public static void main(String[] args) throws FileNotFoundException {
        MapIllustrator map = new MapIllustrator("Colorado_480x480.txt");

        testMinMax(map);

        testDrawMap(map);

        testDrawPath(map);

        testBestPath(map);
    }

    /** output the min and max elevation values found in the map */
    public static void testMinMax(MapIllustrator map) {
        System.out.println("Min: " + map.findMin() + ", max: " + map.findMax());
    }

    /** test map drawing - should be the grayscale image shown in the lab */
    public static void testDrawMap(MapIllustrator map) {
        map.drawMap();

        StdDraw.show();
    }

    /** test the drawPath method, JUST for row 200 */
    public static void testDrawPath(MapIllustrator map) {
        map.drawMap();

        StdDraw.show();

        StdDraw.setPenColor(255, 0, 0);

        int totalChange = map.drawPath(200);

        StdDraw.show();

        System.out.println("Lowest-elevation-change path starting at row 200: " + totalChange); //should be ~18-19,000
    }

    /** test the getIndexOfLowest method, which finds the OVERALL best path / starting row */
    public static void testBestPath(MapIllustrator map) {
        map.drawMap();

        StdDraw.show();

        StdDraw.setPenColor(255, 0, 0);

        int bestRow = map.getIndexOfLowestPath();

        StdDraw.setPenColor(0, 255, 0);

        int totalChange = map.drawPath(bestRow);

        StdDraw.show();

        System.out.println("Overall best lowest-elevation-change path at row: " + bestRow + ", total change of: " + totalChange);
    }
}
