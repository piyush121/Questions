''' https://leetcode.com/problems/combination-sum/ '''

class Solution(object):
    def __init__(self):
        self.res = []
        self.target = 0
        
    def helper(self, cur, rem, sm):
        if not rem:
            return
        
        if sm == self.target:
            self.res.append(sorted(cur))
        elif sm < self.target:
            self.helper(cur + [rem[0]], rem, sm + rem[0])
            self.helper(cur, rem[1:], sm)
        
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.target = target
        if not candidates:
            return self.res
        
        self.helper([], candidates, 0)
        return self.res
