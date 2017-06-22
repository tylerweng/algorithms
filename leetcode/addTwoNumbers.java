/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode sentinel = new ListNode(0);
    ListNode l3 = sentinel;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int v1 = (l1 == null ? 0 : l1.val);
      int v2 = (l2 == null ? 0 : l2.val);
      l3.next = new ListNode((v1 + v2 + carry) % 10);
      l3 = l3.next;
      carry = v1 + v2 + carry >= 10 ? 1 : 0;
      l1 = (l1 == null ? null : l1.next);
      l2 = (l2 == null ? null : l2.next);
    }
    if (carry != 0) l3.next = new ListNode(carry);
    return sentinel.next;
  }
}
