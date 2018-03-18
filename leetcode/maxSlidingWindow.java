class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[q.peek()];
            }
        }
        return res;
    }
}