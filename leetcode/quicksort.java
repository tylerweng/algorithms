import java.util.*;

public class Main {
    public static void helper(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        int pivot = nums[right];
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        helper(nums, left, j);
        helper(nums, i, right);
    }
    public static void quicksort(int[] nums) {
        if (nums.length < 2) return;
        helper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {9, 8, 2, 100, 90, 3, 0, 2};
        System.out.println("Before sort nums: " + Arrays.toString(nums));
        quicksort(nums);
        System.out.println("After sort nums: " + Arrays.toString(nums));
    }
}