''' https://leetcode.com/problems/maximum-subarray/ '''

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        res = [0]*n
        res[0] = nums[0]
        max_sum = nums[0]
        i = 1
        while i < n:
            res[i] = max(res[i-1] + nums[i], nums[i])
            max_sum = max(res[i], max_sum)
            i += 1
            
        return max_sum
