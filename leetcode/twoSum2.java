public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int diff = target - val;
            if (map.containsKey(diff)) {
                int[] res = new int [2];
                res[0] = map.get(diff);
                res[1] = i;
                return res;
            } else {
                map.put(val, i);
            }
        }
        return null;
    }
}