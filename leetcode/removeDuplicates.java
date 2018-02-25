class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int prev = nums[0];
        int swapIdx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[swapIdx] = nums[i];
                swapIdx++;
            }
            prev = nums[i];
        }
        return swapIdx;
    }
}