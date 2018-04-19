class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) return 0;
        int count = 0;
        int prod = 1;
        for (int left = 0, right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (left <= right && prod >= k) {
                prod /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }
}