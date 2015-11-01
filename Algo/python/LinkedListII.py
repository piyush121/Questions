''' https://leetcode.com/problems/linked-list-cycle-ii/ '''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        
        temp = head
        temp2 = head
        hasCycle = False
        while temp and temp2 and temp2.next:
            temp = temp.next
            temp2 = temp2.next.next
            if temp == temp2:
                hasCycle = True
                break
        if hasCycle:
            temp = head
            while temp != temp2:
                temp = temp.next
                temp2 = temp2.next
        else:
            return None
        return temp
