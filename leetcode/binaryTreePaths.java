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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        pathsHelper(root, paths, "");
        return paths;
    }

    private void pathsHelper(TreeNode root, List<String> paths, String path) {
        if (root == null) return;
        if (root.left == null && root.right == null) paths.add(path + root.val);
        if (root.left != null) pathsHelper(root.left, paths, path + root.val + "->");
        if (root.right != null) pathsHelper(root.right, paths, path + root.val + "->");
    }
}
