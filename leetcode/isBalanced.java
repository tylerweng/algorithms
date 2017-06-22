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
  public int depth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(depth(root.left), depth(root.right)) + 1;
  }
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    int leftDepth = depth(root.left);
    int rightDepth = depth(root.right);
    int diff = Math.abs(leftDepth - rightDepth);
    return (
      isBalanced(root.left) &&
      isBalanced(root.right) &&
      diff <= 1
    );
  }
}
