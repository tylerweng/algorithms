/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let behind = head;
    let ahead = head;
    for (let i = 0; i < n; i++) {
        ahead = ahead.next;
    }
    if (ahead === null) return head.next;
    ahead = ahead.next;
    while (ahead !== null) {
        behind = behind.next;
        ahead = ahead.next;
    }
    behind.next = behind.next.next;
    return head;
};
