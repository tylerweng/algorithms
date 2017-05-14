/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

const merge = (left, right) => {
    let dummy = new ListNode(null);
    let node = dummy;
    while (left !== null && right !== null) {
        if (left.val < right.val) {
            node.next = left;
            left = left.next;
        } else {
            node.next = right;
            right = right.next;
        }
        node = node.next;
    }

    if (left !== null) {
        node.next = left;
    }

    if (right !== null) {
        node.next = right;
    }
    return dummy.next;
};
var sortList = function(head) {
    if (head === null || head.next === null) return head;
    let prev = null;
    let slow = head;
    let fast = head;
    while (fast !== null && fast.next !== null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    prev.next = null;
    let left = sortList(head);
    let right = sortList(slow);
    return merge(left, right);
};
