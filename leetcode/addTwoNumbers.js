/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

var reverseList = function(head) {
  let newHead = null;
  while (head !== null) {
      let next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
  }
  return newHead;
};

var addTwoNumbers = function(l1, l2) {
  l1 = reverseList(l1);
  l2 = reverseList(l2);
  let n1 = l1;
  let n2 = l2;
  let dummy = new ListNode(null);
  let n3 = dummy;
  let rem = 0;
  while (n1 !== null || n2 !== null || rem !== 0) {
    let v1 = (n1 === null ? 0 : n1.val);
    let v2 = (n2 === null ? 0 : n2.val);
    console.log(v1 + v2 + rem);
    n3.next = new ListNode((v1 + v2 + rem) % 10);
    rem = (v1 + v2 + rem >= 10 ? 1 : 0);
    n3 = n3.next;
    n1 = (n1 !== null ? n1.next : null);
    n2 = (n2 !== null ? n2.next : null);
  }
  return reverseList(dummy.next);
};
