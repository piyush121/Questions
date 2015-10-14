''' https://leetcode.com/problems/game-of-life/ '''

class Solution(object):
    def getNextState(self, board, i, j, m, n):
        live_n = 0
        if (i-1) >= 0:
            if (j-1) >= 0:
                live_n += board[i-1][j-1]
            live_n += board[i-1][j]
            if (j+1) < n:
                live_n += board[i-1][j+1]
        if (i+1) < m:
            if (j-1) >= 0:
                live_n += board[i+1][j-1]
            live_n += board[i+1][j]
            if (j+1) < n:
                live_n += board[i+1][j+1]
        if (j-1) >= 0:
            live_n += board[i][j-1]
            
        if (j+1) < n:
            live_n += board[i][j+1]
            
        res = board[i][j]
        if res == 0 and live_n == 3:
            res = 1
        elif res == 1:
            if (live_n < 2) or (live_n > 3):
                res = 0
        #print board[i][j], i, j, res, live_n
        return res
        
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        board2=[]
        for i in range(m):
            board2.append([])
            for j in range(n):
                board2[i].append(board[i][j])
        
        for i in range(m):
            for j in range(n):
                board[i][j] = self.getNextState(board2, i, j, m, n)
        
