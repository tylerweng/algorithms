/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) return;
        if (height == res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        helper(root.left, res, height + 1);
        helper(root.right, res, height + 1);
    }
}