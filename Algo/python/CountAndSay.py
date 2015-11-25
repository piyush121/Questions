''' https://leetcode.com/problems/count-and-say/ '''

class Solution(object):
    def getNext(self, s):
        p = s[0]
        c = 0
        res = ''
        for ch in s:
            if ch == p:
                c += 1
            else:
                res += str(c) + p
                p = ch
                c = 1
        res += str(c) + p
        return res
                
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return "1"
        s = '1'
        while n > 1:
            s = self.getNext(s)
            n -= 1
            
        return s
