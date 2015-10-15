''' https://leetcode.com/problems/combinations/ '''

class Solution(object):
    def __init__(self):
        self.res = []
    
    def helper(self, cur_set, k, rem):
        if len(cur_set) == k:
            self.res.append(cur_set)
            return
        else:
            for i in range(0, len(rem)):
                self.helper(cur_set + [rem[i]], k, rem[i+1:])
                
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if k == 0:
            return self.res
        rem = range(1,n+1)
        self.helper([], k, rem)
        return self.res
        
