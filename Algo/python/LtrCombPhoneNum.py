''' https://leetcode.com/problems/letter-combinations-of-a-phone-number/ '''

class Solution(object):
    def __init__(self):
        s = {}
        s['1'], s['2'] = '*','abc'
        s['3'], s['4'] = 'def', 'ghi'
        s['5'], s['6'] = 'jkl', 'mno'
        s['7'], s['8'] = 'pqrs', 'tuv'
        s['9'], s['0'] = 'wxyz', ' '
        self.d = s
        self.res = []
        
    def helper(self, digits, s):
        if not digits:
            self.res.append(s)
        else:
            for c in self.d[digits[0]]:
                self.helper(digits[1:], s + c)
        
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
            return self.res
        self.helper(digits, '')
        return self.res
