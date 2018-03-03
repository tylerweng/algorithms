class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int total = 0;
        for (int i = 1; i <= nums.length; i++) {
            total += i;
        }
        return total - sum;
    }
}