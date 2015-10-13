''' https://leetcode.com/problems/sum-root-to-leaf-numbers/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.total = 0
        
    def helper(self, root, num):
        num = num * 10 + root.val
        
        if not (root.left or root.right):
            self.total += num
            return
        
        if root.left:
            self.helper(root.left, num)
        if root.right:
            self.helper(root.right, num)
            
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        
        self.helper(root, 0)
        return self.total
