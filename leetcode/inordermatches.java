import java.util.*;
class TreeNode {
    public Character val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {

    }
    TreeNode(Character val) {
        this.val = val;
    }

    public static boolean matches(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(n1);
        s2.add(n2);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (s1.isEmpty() || s2.isEmpty()) return false;
            n1 = s1.pop();
            n2 = s2.pop();
            while (n1.left != null) {
                n1 = n1.left;
                s1.add(n1);
            }
            while (n2.left != null) {
                n2 = n2.left;
                s2.add(n2);
            }
            System.out.println(n1.val);
            System.out.println(n2.val);
            if (!n1.val.equals(n2.val)) return false;
            if (n1.right != null) {
                s1.push(n1.right);
            }
            if (n2.right != null) {
                s2.push(n2.right);
            }
        }
        return true;
    }
}
class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode('g');
        n1.left = new TreeNode('o');
        n1.left.left = new TreeNode('d');
        TreeNode n2 = new TreeNode('o');
        n2.left = new TreeNode('d');
        n2.right = new TreeNode('g');
        System.out.println(TreeNode.matches(n1, n2));
    }
}