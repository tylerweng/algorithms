public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(
                    Math.min(height[left], height[right]) * (right - left),
                    area
            );
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return area;
    }
}