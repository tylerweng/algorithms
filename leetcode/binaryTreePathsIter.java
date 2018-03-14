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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<String> paths = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.push(root);
        pathStack.push("");
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();
            String val = Integer.toString(node.val);
            if (node.left == null && node.right == null) {
                paths.add(path + val);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                pathStack.push(path + val + "->");
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                pathStack.push(path + val + "->");
            }
        }
        return paths;
    }
}