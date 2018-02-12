class Solution {
    public void helper(int idx, int[] nums, boolean[] reachable) {
        reachable[idx] = true;
        if (reachable[nums.length - 1]) return;
        for (int i = nums[idx]; i >= 1; i--) {
            int nextIdx = idx + i;
            if (nextIdx < nums.length && !reachable[nextIdx]) {
                helper(nextIdx, nums, reachable);
            }
        }
    }
    public boolean canJump2(int[] nums) {
        if (nums.length < 2) return true;
        boolean[] reachable = new boolean[nums.length];
        helper(0, nums, reachable);
        return reachable[nums.length - 1];
    }
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}