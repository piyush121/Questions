''' https://leetcode.com/problems/binary-tree-postorder-traversal/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.res = []
    
    def helper(self, root):
        if not root:
            return
        if not (root.left or root.right):
            self.res.append(root.val)
            return
        if root.left:
            self.helper(root.left)
        if root.right:
            self.helper(root.right)
            
        self.res.append(root.val)
        
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.helper(root)
        return self.res
