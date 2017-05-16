/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    const n = nums.length;
    const dp = [];
    dp[0] = nums[0];
    let max = dp[0];

    for (let i = 1; i < n; i++) {
        dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
        max = Math.max(max, dp[i]);
    }
    return max;
};
