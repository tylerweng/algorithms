/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */

var depth = function(root) {
    if (root === null) return 0;
    return Math.max(depth(root.left), depth(root.right)) + 1;
};

var isBalanced = function(root) {
    if (root === null) return true;
    let leftDepth = depth(root.left);
    let rightDepth = depth(root.right);
    let diff = Math.abs(leftDepth - rightDepth);
    return isBalanced(root.left) && isBalanced(root.right) && diff <= 1;
};
