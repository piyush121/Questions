''' https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/ '''

class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        lst = []
        index = -1
        preorder = preorder.split(",")
        ln = len(preorder)
        root_flag = False
        if len(preorder) == 1 and preorder[0] == '#':
            return True
        
        for i,c in enumerate(preorder):
            # enumerate over each element in preorder tree
            if c == '#':
                if not lst:
                    return False
                
                lst[-1].append(True)
                while index >= 0 and len(lst[-1]) > 2:
                    lst.pop()
                    index -= 1
                if index == -1 and i + 1 != ln:
                    return False
                
            else:
                root_flag = True
                if lst:
                    x = lst[index]
                    x.append(True)
                index += 1
                lst.append([c])
                
        while index >= 0:
            x = lst[index]
            if len(x) == 3:
                index -= 1
            else:
                break
        return not (index >= 0)
