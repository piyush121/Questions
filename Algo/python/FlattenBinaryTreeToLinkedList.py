''' https://leetcode.com/problems/flatten-binary-tree-to-linked-list/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        stack = [root]
        while stack:
            node = stack.pop()
            if node.right:
                stack.append(node.right)
            if node.left:
                node.right = node.left
                stack.append(node.left)
                node.left = None
            if not (node.left or node.right) and stack:
                temp = stack.pop()
                node.right = temp
                stack.append(temp)
