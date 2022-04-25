import java.util.*;

public class SearchSort {
    private int[] nums;

    public SearchSort(int[] nums) {
        this.nums = nums;
    }

    public SearchSort(int size) {
        this.nums = new int[size];
        initArray();
    }

    public void initArray() {
        Random random = new Random();
        for (int index = 0; index < nums.length; index++) {
            nums[index] = random.nextInt() * 1000 + 1;
        }
    }

    public void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int linearSearch(int key) {
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == key) {
                return index;
            }
        }
        return -1;
    }

    public int linearSearchRecur(int key) {
        return linearSearchRecur(key, 0);
    }

    private int linearSearchRecur(int key, int index) {
        if (index == nums.length) {
            return -1;
        } else {
            if (nums[index] == key) {
                return index;
            }
            return linearSearchRecur(key, index + 1);
        }
    }

    public int binarySearch(int key) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (key < nums[mid]) {
                max = mid - 1;
            } else if (key > nums[mid]) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearchRecur(int key) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return binarySearchRecur(key, 0, nums.length - 1);
    }

    private int binarySearchRecur(int key, int min, int max) {
        int mid = (min + max) / 2;

        if (key == nums[mid]) {
            return mid;
        } else {
            if (key < nums[mid] && min != max) {
                return binarySearchRecur(key, min, mid - 1);
            } else if (key > nums[mid] && min != max) {
                return binarySearchRecur(key, mid + 1, max);
            }
            return -1;
        }
    }

    public void bubbleSort(boolean print) {
        int counter = 1;
        System.out.println(Arrays.toString(nums));

        while (counter != 0) {
            counter = 0;
            for (int index = 0; index < nums.length - 1; index++) {
                if (nums[index] > nums[index + 1]) {
                    swap(index, index + 1);
                    counter++;
                    if (print) {
                        System.out.println(Arrays.toString(nums));
                    }
                }
            }
        }
    }

    public void selectionSort(boolean print) {
        System.out.println(Arrays.toString(nums));

        for (int index = 0; index < nums.length - 1; index++) {
            int minIndex = index;
            for (int index2 = index + 1; index2 < nums.length; index2++) {
                if (nums[index2] < nums[minIndex]) {
                    minIndex = index2;
                }
            }
            swap(minIndex, index);
            if (print) {
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    public void insertionSort(boolean print) {
        System.out.println(Arrays.toString(nums));

        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index + 1] < nums[index]) {
                swap(index, index + 1);
                for (int index2 = index; index2 > 0; index2--) {
                    if (nums[index2] < nums[index2 - 1]) {
                        swap(index2 - 1, index2);
                        if (print) {
                            System.out.println(Arrays.toString(nums));
                        }
                    }
                }
            }
        }
    }

    public void mergeSort(boolean print, int[] arr, int len) {
        if (len < 2) {
            return;
        }
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for (int index = 0; index < mid; index++) {
            left[index] = arr[index];
        }
        for (int index = mid; index < len; index++) {
            right[index - mid] = arr[index];
        }

        if (print) {
            System.out.print(Arrays.toString(left));
            System.out.print(" ");
            System.out.println(Arrays.toString(right));
        }

        mergeSort(print, left, mid);
        mergeSort(print, right, len - mid);
        mergeSort(left, right);

        if (print) {
            System.out.print(Arrays.toString(arr));
        }
    }

    public void mergeSort(int[] left, int[] right) {
        int[] arrFinal = new int[left.length + right.length];
        int index = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < left.length && index2 < right.length) {
            if (left[index1] <= right[index2]) {
                arrFinal[index++] = left[index1++];
            }
            else {
                arrFinal[index++] = right[index2++];
            }
        }

        while (index1 < left.length) {
            arrFinal[index++] = left[index1++];
        }
        while (index2 < right.length) {
            arrFinal[index++] = right[index2++];
        }
    }
}