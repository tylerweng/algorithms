/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int rem = 0;
        while (l1 != null || l2 != null || rem != 0) {
            ListNode next = new ListNode(0);
            int l1v = (l1 == null ? 0 : l1.val);
            int l2v = (l2 == null ? 0 : l2.val);
            int sum = l1v + l2v + rem;
            next.val = sum % 10;
            rem = sum / 10;
            head.next = next;
            head = next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}