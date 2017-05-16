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

var postorderHelper = function(root, path) {
    if (root === null) return path;
    postorderHelper(root.left, path);
    postorderHelper(root.right, path);
    path.push(root.val);
    return path;
};

var postorderTraversal = function(root) {
    const path = [];
    return postorderHelper(root, path);
};
