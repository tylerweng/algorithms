class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);
                int sum = left + right + 1;

                max = Math.max(max, sum);

                if (left > 0) map.put(num-left, sum);
                if (right > 0) map.put(num+right, sum);
                map.put(num, sum);
            }
        }
        return max;
    }
}