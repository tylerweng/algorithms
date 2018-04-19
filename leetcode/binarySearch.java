class Solution {
    // return left-most idx of target if in sorted int[] nums else -1
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                idx = mid;
                right = mid - 1;
                // left = mid + 1 would return right-most idx of target
            }
        }
        return idx;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 3, 4};
        System.out.println(Solution.binarySearch(nums, 0) == 0);
        System.out.println(Solution.binarySearch(nums, 1) == 2);
        System.out.println(Solution.binarySearch(nums, 4) == 7);
    }
}