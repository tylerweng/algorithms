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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(root, wrapList, 0);
        return wrapList;
    }
    public void levelMaker(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(root.left, list, level + 1);
        levelMaker(root.right, list, level + 1);
        list.get(list.size()-level-1).add(root.val);
    }
}
