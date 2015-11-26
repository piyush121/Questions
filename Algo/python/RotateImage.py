''' https://leetcode.com/problems/rotate-image/ '''

class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        if n == 1:
            return
        cm = []
        for lst in matrix:
            cm.append([i for i in lst])
            
        for i in range(n):
            for j in range(n):
                matrix[j][n-i-1] = cm[i][j]
