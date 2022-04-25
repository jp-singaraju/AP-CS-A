import java.util.*;

public class TwoDArrayProbs
{
    private int[][] nums;
    
    public TwoDArrayProbs(int[][] nums) {
        this.nums = nums;
    }
    
    public int sum() {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                sum += nums[i][j];
            }
        }
        return sum;
    }
    
    public boolean isSquare() {
        int height = nums.length;
        int width = nums[0].length;
        if (height == width) {
            return true;
        }
        return false;
    }
    
    public void addMatrix(int[][] other) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] += other[i][j];
            }
        }
        print(nums);
    }
    
    private void print (int[][] nums) {
        for (int[] numArray : nums) {
            System.out.println(Arrays.toString(numArray));
        }
    }
    
    public int columnSum(int col) {
        int sum = 0;
        for (int[] numArray : nums) {
            if (numArray.length - 1 >= col) {
                sum += numArray[col];
            }
        }
        return sum;
    }
    
    public boolean isColumnMagic() {
        int greatestLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length > greatestLen) {
                greatestLen = nums[i].length;
            }
        }
        int[] sum = new int[greatestLen];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                sum[j] += nums[i][j];
            }
        }
        int prevNum = sum[0];
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] != prevNum) {
                return false;
            }
        }
        return true;
    }
    
    public int diagDifference() {
        int diag1sum = 0;
        int diag2sum = 0;
        int countUp = nums[0].length - 1;
        int countDown = 0;
        for (int i = 0; i < nums.length; i++) {
            diag1sum += nums[i][countDown];
            diag2sum += nums[i][countUp];
            countDown++;
            countUp--;
        }
        return Math.abs((diag1sum - diag2sum));
    }  
    
    public int[][] getNums() {
        return nums;
    }
    
    public void setNums(int[][] nums) {
        this.nums = nums;
    }
}
