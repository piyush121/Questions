''' https://leetcode.com/problems/bulls-and-cows/ '''

class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        if not secret:
            return "0A0B"
            
        A = 0
        B = 0
        ln = len(secret)
        d = {}
        for i in range(ln):
            if secret[i] == guess[i]:
                A += 1
            else:
                if guess[i] in d:
                    d[guess[i]] = d[guess[i]] + 1
                else:
                    d[guess[i]] = 1
                    
        for i in range(ln):
            if secret[i] != guess[i]:
                if secret[i] in d:
                    n = d[secret[i]]
                    n -= 1
                    if n:
                        d[secret[i]] = n
                    else:
                        d.pop(secret[i])
                    B += 1
                    
        return str(A) + 'A' + str(B) + 'B'
