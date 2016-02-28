''' https://leetcode.com/problems/maximum-depth-of-binary-tree/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        
        if not root.left and not root.right:
            return 1
            
        l = 1 + self.maxDepth(root.left)
        r = 1 + self.maxDepth(root.right)
        
        if l > r:
            return l
        else:
            return r
        
