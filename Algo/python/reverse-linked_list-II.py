''' https://leetcode.com/problems/reverse-linked-list-ii/ '''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if not head:
            return head
        if m == n:
            return head
            
        i = 1
        temp = head
        last = None
        while i < m:
            last = temp
            temp = temp.next
            i += 1
        
        tail = temp
        nxt = temp.next
        prev = None
        while i < n:
            temp.next = prev
            prev = temp
            temp = nxt
            nxt = nxt.next
            i += 1
        temp.next = prev
        tail.next = nxt
        
        if m == 1:
            head = temp
        else:    
            last.next = temp
        return head
