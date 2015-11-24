''' https://leetcode.com/problems/range-sum-query-2d-immutable/ '''

class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        rows = len(matrix)
        # cols = len(matrix[0])
        self.sum_mat = []
        for i in range(rows):
        	self.sum_mat.append(list(self.accumu(matrix[i])))
        # print self.mat
        # print self.sum_mat
        
    def accumu(self, lis):
        total = 0
        for x in lis:
            total += x
            yield total
	
    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        total = 0
        for i in range(row1, row2 + 1):
            total += self.sum_mat[i][col2]
            # print total,
            if col1 > 0:
               total -= self.sum_mat[i][col1-1]
               # print total,
            # print total
        return total
