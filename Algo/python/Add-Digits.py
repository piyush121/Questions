''' https://leetcode.com/problems/add-digits/ '''

class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if not num:
            return num
        return num - 9*((num-1)/9)
