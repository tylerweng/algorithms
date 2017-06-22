/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int midx = (start + end) / 2;
        TreeNode root = new TreeNode(nums[midx]);
        root.left = helper(nums, start, midx - 1);
        root.right = helper(nums, midx + 1, end);
        return root;
    }
}
