''' https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.res = []
        self.length = 0
        
    def helper(self, root, lvl):
        if self.length == lvl:
            self.res.append([root.val])
            self.length += 1
        else:
            if (lvl & 1) == 1: 
                self.res[lvl].insert(0,root.val)
            else:
                self.res[lvl].append(root.val)
        
        if root.left:
            self.helper(root.left, lvl + 1)
        if root.right:
            self.helper(root.right, lvl + 1)
            
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return self.res
            
        self.helper(root, 0)
        return self.res
