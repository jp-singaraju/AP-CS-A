import java.util.*;

public class SoundLabProbs {
    public SoundLabProbs() {
        
    }
    
    public int LastIndexOf(int[] nums, int value) {
        for (int index = nums.length - 1; index > 0; index--) {
            if (nums[index] == value) {
                return index;
            }
        }
        return -1;
    }
    
    public int range(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > max) {
                max = nums[index];
            } else if (nums[index] < min) {
                min = nums[index];
            }
        }
        return max - min;
    }
    
    public int minDifference(int[] nums) {
        int min = Math.abs(nums[0] - nums[1]);
        for (int index = 1; index < nums.length - 1; index++) {
            if (Math.abs(nums[index] - nums[index + 1]) < min) {
                min = Math.abs(nums[index] - nums[index + 1]);
            }
        }
        return min;
    }
    
    public String reverseWords(String str) {
        String newStr = "";
        String[] words = str.split(" ");
        for (int index = words.length - 1; index >= 0; index--) {
            newStr += words[index] + " ";
        }
        return newStr;
    }
    
    public int priceIsRight(int[] birds, int price) {
        int indexVal = 0;
        boolean isLarge = true;
        int min = birds[0];
        for (int index = 0; index < birds.length; index++) {
            if (birds[index] <= price) {
                isLarge = false;
            }
            if (birds[index] < price && Math.abs(birds[index] - price) < min) {
                min = Math.abs(birds[index] - price);
                indexVal = index;
            }
        }
        if (isLarge == true) {
            return -1;
        }
        return birds[indexVal];
    }
    
    public int[] productExceptSelf(int[] nums) {
        int[] productArr = new int[nums.length];
        int product = 0;
        for (int index = 0; index < nums.length; index++) {
            product = 1;
            for (int value = 0; value < nums.length; value++) {
                product *= nums[value];
            }
            product /= nums[index];
            productArr[index] = product;
        }
        return productArr;
    }
}
