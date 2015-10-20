''' https://leetcode.com/problems/binary-tree-postorder-traversal/ '''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        stack = [root]
        visited = [False]
        res = []
        while stack:
            node = stack.pop()
            flag = visited.pop()
            if flag:
                res.append(node.val)
                continue
            if not(node.left or node.right):
                res.append(node.val)
                continue
            
            stack.append(node)
            visited.append(True)
            if node.right:
                stack.append(node.right)
                visited.append(False)
            if node.left:
                stack.append(node.left)
                visited.append(False)
                
        return res
