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
    List<Integer> list;
    Integer prev;
    int currFreq = 1, maxFreq = 0;
    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                currFreq++;
            else
                currFreq = 1;
        }
        if (currFreq > maxFreq) {
            maxFreq = currFreq;
            list.clear();
            list.add(root.val);
        } else if (currFreq == maxFreq) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        list = new ArrayList<>();
        traverse(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}