import java.util.*;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Integer intervalMin = null;
        Integer max = null;
        Integer idxStart = null;
        Integer idxEnd = null;

        if (nums.length < 2) return 0;
        max = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] > max){
                max = nums[i+1];
            }
            if(nums[i+1] < max){
                idxEnd = i+1;
            }

            if (nums[i] > nums[i + 1]) {
                idxEnd = i + 1;
                if (intervalMin == null || nums[i + 1] < intervalMin) {
                    intervalMin = nums[i + 1];
                }
            }
        }
        if (idxEnd == null) {
            return 0;
        }
        for (int j = 0; j <= idxEnd; j++) {
            if (nums[j] > intervalMin) {
                return (idxEnd - j) + 1;
            }
        }
        return 0;
    }
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) return 0;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int start = -1;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            return 0;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != sorted[j]) {
                end = j;
                break;
            }
        }
        return (end - start) + 1;
    }
}