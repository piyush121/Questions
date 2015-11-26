''' https://leetcode.com/problems/range-sum-query-immutable/ '''

class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self.numbers = nums
        self.sums = []
        p = 0
        for c in nums:
            self.sums.append(c + p)
            p += c
    
    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        if i == 0:
        	return self.sums[j]
        return self.sums[j] - self.sums[i] + self.numbers[i]

# 16/16
# 92 ms
