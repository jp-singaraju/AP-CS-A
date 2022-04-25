import java.util.*;

public class TwoDRunner
{
    public static void main(String[] args) {
        int[][] myNums = {{1, 2}, {10, 11}};
        TwoDArrayProbs arr1 = new TwoDArrayProbs(myNums);
        
        //1
        System.out.println(arr1.sum());
        
        //2
        arr1.setNums(new int [][] {{2, 3, 1}, {5, 4, 6}});
        System.out.println(arr1.isSquare());
        
        //3
        int[][] testNums = {{2, 3, 1}, {3, 1, 2}};
        arr1.setNums(new int [][] {{1, 2, 3}, {3, 2, 1}});
        arr1.addMatrix(testNums);
        
        //4
        arr1.setNums(new int [][] {{1, 2, 3}, {4, 5, 6}, {6}});
        System.out.println(arr1.columnSum(2));
        
        //5
        arr1.setNums(new int [][] {{1, 2, 3}, {1}, {2, 2, 1}});
        System.out.println(arr1.isColumnMagic());
        
        //6
        arr1.setNums(new int [][] {{1, 2, 3}, {3, 2, 1}, {7, 2, 2}});
        System.out.println(arr1.diagDifference());
        arr1.setNums(new int [][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}});
        System.out.println(arr1.diagDifference());
    }
}
