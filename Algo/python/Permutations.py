''' https://leetcode.com/problems/permutations/ '''

class Solution(object):
    def __init__(self):
        self.lst = []
        
    def helper(self, curr, rem):
        if not rem:
            self.lst.append(curr)
        else:
            ln = len(rem)
            for i in range(0, ln):
                self.helper(curr + [rem[i]], rem[:i] + rem[i+1:])
                
        
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return self.lst
        
        self.helper([], nums)
        return self.lst
