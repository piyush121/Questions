''' https://leetcode.com/problems/path-sum-ii/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.sum = 0
        self.paths = []
        
    def helper(self, root, cur_sum, path):
        cur_sum += root.val
        path = path + [root.val]
        if not (root.left or root.right):
            if cur_sum == self.sum:
                self.paths.append(path)
            return
        
        if root.left:
            self.helper(root.left, cur_sum, path)
        
        if root.right:
            self.helper(root.right, cur_sum, path)
        
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if not root:
            return self.paths
        self.sum = sum
        self.helper(root, 0, [])
        return self.paths
