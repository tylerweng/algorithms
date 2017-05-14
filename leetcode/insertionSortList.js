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
var insertionSortList = function(head) {
    if (head === null || head.next === null) return head;
    let dummy = new ListNode(null);
    let curr = head;
    let prev = dummy;
    let next = null;

    while (curr !== null) {
        next = curr.next;
        while (prev.next !== null && prev.next.val < curr.val) {
            prev = prev.next;
        }
        curr.next = prev.next;
        prev.next = curr;
        prev = dummy;
        curr = next;
    }

    return dummy.next;
};
