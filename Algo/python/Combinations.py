''' https://leetcode.com/problems/combinations/ '''

class Solution(object):
    def __init__(self):
        self.res = []
    
    def helper(self, cur_set, k, low, high):
        if len(cur_set) == k:
            self.res.append(cur_set)
            return
        else:
            for i in range(low, high + 1):
                self.helper(cur_set + [i], k, i + 1, high)
                
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if k == 0:
            return self.res
        self.helper([], k, 1, n)
        return self.res
        
