# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import random
import sys
class Solution(object):

    def __init__(self, head):
        """
        @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node.
        :type head: ListNode
        """
        self.head = head



    def getRandom(self):
        """
        Returns a random node's value.
        :rtype: int
        """
        res = self.head.val
        node = self.head.next
        i = 2
        while node:
            j = random.randint(0, sys.maxsize) % i
            if j == 0:
                res = node.val
            i += 1
            node = node.next
        return res



        # Your Solution object will be instantiated and called as such:
        # obj = Solution(head)
        # param_1 = obj.getRandom()