class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int numZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeroes++;
            } else {
                prod *= nums[i];
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (numZeroes > 1 || (nums[j] != 0 && numZeroes > 0)) {
                nums[j] = 0;
            } else {
                nums[j] = nums[j] == 0 ? prod : prod / nums[j];
            }
        }
        return nums;
    }
}