/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */

var inorderHelper = function(root, path) {
    if (root === null) return path;
    inorderHelper(root.left, path);
    path.push(root.val);
    inorderHelper(root.right, path);
    return path;
};

var inorderTraversal = function(root) {
    const path = [];
    return inorderHelper(root, path);
};
