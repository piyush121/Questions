''' https://leetcode.com/problems/copy-list-with-random-pointer/ '''

# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return head
            
        new_head = RandomListNode(head.label)
        temp = new_head
        orig = head
        node_map = {head.label: new_head}
        while orig:
            if orig.random:
                if orig.random.label in node_map:
                    temp.random = node_map[orig.random.label]
                else:
                    node = RandomListNode(orig.random.label)
                    temp.random = node
                    node_map[node.label] = node
            if orig.next:
                if orig.next.label in node_map:
                    temp.next = node_map[orig.next.label]
                else:
                    node = RandomListNode(orig.next.label)
                    temp.next = node
                    node_map[node.label] = node
            orig = orig.next
            temp = temp.next
            
        return new_head
