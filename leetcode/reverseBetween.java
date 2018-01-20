public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode behind = dummy;
        while (--m > 0) {
            behind = behind.next;
            --n;
        }
        ListNode curr = behind.next;
        ListNode ahead = curr.next;
        while (--n > 0) {
            curr.next = ahead.next;
            ahead.next = behind.next;
            behind.next = ahead;
            ahead = curr.next;
        }

        return dummy.next;
    }
}