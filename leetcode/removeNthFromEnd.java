/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode ahead = dummy;
        curr.next = head;
        while (n-- >= 0) {
            ahead = ahead.next;
        }
        while (ahead != null) {
            curr = curr.next;
            ahead = ahead.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}