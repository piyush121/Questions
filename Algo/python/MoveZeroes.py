''' https://leetcode.com/problems/move-zeroes/ '''

class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        zIndex = 0
        nzIndex = 0
        ln = len(nums)
        if ln < 2:
            return
        
        while zIndex < ln and nzIndex < ln:
            while zIndex < ln and nums[zIndex] != 0:
                zIndex += 1
        
            nzIndex = zIndex
            while nzIndex < ln and nums[nzIndex] == 0:
                nzIndex += 1
                
            #print zIndex, nzIndex, ln
            if zIndex < nzIndex and nzIndex < ln:
                nums[zIndex] = nums[nzIndex]
                nums[nzIndex] = 0
                zIndex += 1
                nzIndex += 1
            else:
                break
        
