''' https://leetcode.com/problems/invert-binary-tree/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root or (not root.left and not root.right):
            return root
        
        self.invertTree(root.left)
        self.invertTree(root.right)
        
        temp = root.left
        root.left = root.right
        root.right = temp
        
        return root
