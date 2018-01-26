// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> window = new HashMap<>();
        for (int i : A) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }
        int left = 0;
        int minLen = A.length + 1;
        int count = 0;
        int trueRight = 0;

        for (int right = 0; right < A.length; right++) {
            int val = A[right];
            if (!window.containsKey(val)) {
                window.put(val, 1);
                count++;
            } else {
                window.put(val, window.get(val) + 1);
            }
            // found right bound s.t. we have all the unique ints
            if (count == map.size()) {
                int leftVal = A[left];
                while (window.get(leftVal) > 1) {
                    window.put(leftVal, window.get(leftVal) - 1);
                    left++;
                    leftVal = A[left];
                }
                minLen = (right - left) + 1;
                trueRight = right;
            }
        }

        // find answer with above right bound as left bound

        if (A.length - trueRight < map.size()) return minLen;

        int leftX = trueRight;
        int minLenX = A.length + 1;
        int countX = 0;

        Map<Integer, Integer> windowX = new HashMap<>();

        for (int rightX = trueRight; rightX < A.length; rightX++) {
            int valX = A[rightX];
            if (!windowX.containsKey(valX)) {
                windowX.put(valX, 1);
                countX++;
            } else {
                windowX.put(valX, windowX.get(valX) + 1);
            }
            // found right bound s.t. we have all the unique ints
            if (countX == map.size()) {
                int leftValX = A[leftX];
                while (windowX.get(leftValX) > 1) {
                    windowX.put(leftValX, windowX.get(leftValX) - 1);
                    leftX++;
                }
                minLenX = (rightX - leftX) + 1;
            }
        }
        return Math.min(minLen, minLenX);

    }
}