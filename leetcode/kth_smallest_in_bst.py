def kth_smallest_in_bst(root, k):
    count = count_nodes(root.left, k)
    if k <= count:
        return kth_smallest_in_bst(root.left, k)
    elif k > count + 1:
        return kth_smallest_in_bst(root.right, k - (count + 1))
    return root.val


def count_nodes(root):
    if root is None:
        return 0
    return 1 + count_nodes(root.left) + count_nodes(root.right)
