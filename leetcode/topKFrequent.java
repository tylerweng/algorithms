import java.util.*;

class Solution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = buckets.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (buckets[pos] != null) {
                for (Integer n2: buckets[pos]) {
                    if (res.size() < k) {
                        res.add(n2);
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,2};
        int k = 2;
        System.out.println(Solution.topKFrequent(nums, k));
    }
}