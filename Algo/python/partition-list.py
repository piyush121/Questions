''' https://leetcode.com/problems/partition-list/ '''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        if not (head and head.next):
            return head
        low = None
        high = None
        temp = head
        if head.val < x:
            low = head
            while temp.next and temp.next.val < x:
                temp = temp.next
        else:
            high = head
            while temp.next and temp.next.val >= x:
                temp = temp.next
        
        if not temp.next:
            return head
        temp_low = None
        temp_high = None
        if low:
            high = temp.next
            temp_high = high
            temp_low = temp
        else:
            low = temp.next
            temp_low = low
            temp_high = temp
        
        temp = temp.next.next
        while temp:
            #print temp.val
            if temp.val < x:
                temp_low.next = temp
                temp_low = temp
            else:
                temp_high.next = temp
                temp_high = temp
            temp = temp.next
        
        head = low
        temp_low.next = high
        temp_high.next = None
        #print head.val
        return head
