''' https://leetcode.com/problems/game-of-life/ '''
class Solution(object):
    def __init__(self):
        self.m = 0
        self.n = 0
    def getNextState(self, board, i, j):
        if i == self.m:
            return
        live_n = 0
        if (i-1) >= 0:
            if (j-1) >= 0:
                live_n += board[i-1][j-1]
            live_n += board[i-1][j]
            if (j+1) < self.n:
                live_n += board[i-1][j+1]
        if (i+1) < self.m:
            if (j-1) >= 0:
                live_n += board[i+1][j-1]
            live_n += board[i+1][j]
            if (j+1) < self.n:
                live_n += board[i+1][j+1]
        if (j-1) >= 0:
            live_n += board[i][j-1]
            
        if (j+1) < self.n:
            live_n += board[i][j+1]
            
        res = board[i][j]
        if res == 0 and live_n == 3:
            res = 1
        elif res == 1:
            if (live_n < 2) or (live_n > 3):
                res = 0
        #print board[i][j], i, j, res, live_n
        if (j+1) < self.n:
            self.getNextState(board, i, j + 1)
        else:
            self.getNextState(board, i + 1, 0)
        board[i][j] = res
        
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self.m = len(board)
        self.n = len(board[0])
        if self.m == 0 or self.n==0:
            return
        self.getNextState(board, 0, 0)
        
