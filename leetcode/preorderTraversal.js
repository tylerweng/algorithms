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

var preorderHelper = function(root, path) {
    if (root === null) return path;
    path.push(root.val);
    preorderHelper(root.left, path);
    preorderHelper(root.right, path);
    return path;
};

var preorderTraversal = function(root) {
    const path = [];
    return preorderHelper(root, path);
};
