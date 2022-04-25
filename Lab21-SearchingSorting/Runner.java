public class Runner {
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 8, 7, 9, 1, 5};
        SearchSort obj = new SearchSort(nums);
        obj.mergeSort(true, nums, nums.length);
    }
}