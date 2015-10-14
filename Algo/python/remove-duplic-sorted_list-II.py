''' https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ '''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        temp = head
        head = None
        last = None
        while temp and temp.next:
            flag = False
            while temp.next and temp.val == temp.next.val:
                flag = True
                temp1 = temp.next
                temp.next = temp1.next
                temp1.next = None
                temp1 = temp.next
                #print temp.val, temp1.val
            if flag:
                if last:
                    last.next = temp1
                temp = temp1
            else:
                if not head:
                    head = temp
                last = temp
                temp = temp.next
        if last:
            last.next = temp
        if not head:
            head = temp
        return head
