import java.io.*;
import java.io.IOException;
import java.util.*;

public class MapIllustrator
{
    private int[][] grid;
    private int rows;
    private int cols;

    public MapIllustrator(String filename) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new File(filename));
        rows = reader.nextInt();
        cols = reader.nextInt();
        grid = new int[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = reader.nextInt();
            }
        }
        initCanvas();
    }

    /** initialize the drawing window */
    private void initCanvas() {
        StdDraw.setCanvasSize(cols, rows);
        StdDraw.setXscale(0, cols);
        StdDraw.setYscale(0, rows);
        StdDraw.enableDoubleBuffering();
    }

    /** @return the min value in the entire grid */
    public int findMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < min) {
                    min = grid[i][j];
                }
            }
        }
        return min;
    }

    /** @return the max value in the entire grid */
    public int findMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }

    /**
     * Draws the grid (map)
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap() {
        int range = findMax() - findMin();
        int margin = findMax() - range;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int color = (int)((grid[i][j] - margin) * 255 / range);
                StdDraw.setPenColor(color, color, color);
                StdDraw.filledRectangle(j, grid.length - 1 - i, 0.5, 0.5);
            }
        }
    }

    /**
     * Find/draw a greedy path from West-to-East, starting at given row.
     * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawPath(int row) {
        int total = 0;
        int prev;
        StdDraw.filledRectangle(0, grid.length - 1 - row, 0.5, 0.5);
        for (int j = 1; j < grid[0].length; j++) {
            prev = row;
            int min = Integer.MAX_VALUE;
            int index = -2;
            int[] diffArr = new int[3];
            int counter = 0;
            for (int i = -1; i < 2; i++) {
                int val = 0;
                if (row + i < 0 || row + i >= grid.length) {
                    val = Integer.MAX_VALUE;
                } else {
                    val = Math.abs(grid[row][j - 1] - grid[row + i][j]);
                }
                if (val < min) {
                    min = val;
                    index = i;
                }
                diffArr[counter] = val;
                counter++;
            }
            if (diffArr[1] == min && (diffArr[0] == diffArr[1] || diffArr[2] == diffArr[1])) {
                index = 0;
            } else if (diffArr[1] != min && (diffArr[0] == diffArr[2])) {
                int rand = (int)(Math.random() * 2 + 1);
                if (rand == 1) {
                    index = -1;
                }
                if (rand == 2) {
                    index = 1;
                }
            }
            total += Math.abs(grid[row][j - 1] - grid[row + index][j]);
            row = prev + index;
            StdDraw.filledRectangle(j, grid.length - 1 - row, 0.5, 0.5);
        }
        return total;
    }

    /** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
    public int getIndexOfLowestPath() { 
        int min = Integer.MAX_VALUE;
        int rowNum = 0;
        for (int row = 0; row < grid.length - 1; row++) {
            int var = drawPath(row);
            if (var < min) {
                min = var;
                rowNum = row;
            }
        }
        return rowNum;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}