''' https://leetcode.com/problems/unique-paths-ii/ '''

class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1:
            return 0
        flag = True
        for i in range(n):
            if obstacleGrid[0][i] == 1:
                obstacleGrid[0][i] = -1
                flag = False
            else:
                if flag:
                    obstacleGrid[0][i] = 1
        
        flag = True
        for i in range(1,m):
            if obstacleGrid[i][0] == 1:
                obstacleGrid[i][0] = -1
                flag = False
            else:
                if flag:
                    obstacleGrid[i][0] = 1
        
        for i in range(1,m):
            for j in range(1,n):
                if obstacleGrid[i][j] == 1:
                    obstacleGrid[i][j] = -1
                else:
                    if obstacleGrid[i-1][j] > 0 and obstacleGrid[i][j-1] > 0:
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
                    else:
                        obstacleGrid[i][j] = max(obstacleGrid[i-1][j], obstacleGrid[i][j-1])
        if obstacleGrid[m-1][n-1] == -1:
            return 0
        return obstacleGrid[m-1][n-1]
                
