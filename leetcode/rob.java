class Solution {
    public int helper(int [] nums, int left, int right) {
        int skipPrev = 0;
        int usePrev = 0;
        for (int i = left; i <= right; i++) {
            int temp = skipPrev;
            skipPrev = Math.max(skipPrev, usePrev);
            usePrev = nums[i] + temp;
        }
        return Math.max(skipPrev, usePrev);
    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
}