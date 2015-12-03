''' https://leetcode.com/problems/valid-anagram/ '''

class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        d = {}
        if len(s) != len(t):
            return False
        for c in s:
            if c in d:
                d[c] = d[c] + 1
            else:
                d[c] = 1
        
        for c in t:
            if (c not in d) or (d[c] == 0):
                return False
            d[c] = d[c] - 1
        
        ##s = d.keys()
        ##for c in s:
        ##    if d[c] != 0:
        ##        return False
                
        return True
