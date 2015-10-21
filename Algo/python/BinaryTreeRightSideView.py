''' https://leetcode.com/problems/binary-tree-right-side-view/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.rsv = []
        self.d = {}
        
    def helper(self, root, lvl):
        if root.right:
            if not self.d[lvl]:
                self.rsv.append(root.right.val)
                self.d[lvl] = True
            if (lvl+1) not in self.d:
                self.d[lvl + 1] = False
            self.helper(root.right, lvl + 1)
            
        if root.left:
            if not self.d[lvl]:
                self.rsv.append(root.left.val)
                self.d[lvl] = True
            if (lvl+1) not in self.d:
                self.d[lvl + 1] = False
            self.helper(root.left, lvl + 1)
        
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return self.rsv
        self.rsv.append(root.val)
        self.d[1] = False
        self.helper(root, 1)
        return self.rsv
