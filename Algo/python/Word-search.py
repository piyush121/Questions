''' https://leetcode.com/problems/word-search/ '''

class Solution(object):
    def __init__(self):
        self.rows = 0
        self.cols = 0
        
    def helper(self, board, word, i, j, wi, ln):
        if wi == ln:
            return True
        res = False
        
        if (i+1 < self.rows) and (board[i+1][j] == word[wi]):
            board[i+1][j] = '0'
            res = self.helper(board, word, i+1, j, wi+1, ln)
            if res:
                return res
            board[i+1][j] = word[wi]
        if (i > 0) and (board[i-1][j] == word[wi]):
            board[i-1][j] = '0'
            res = self.helper(board, word, i-1, j, wi+1, ln)
            if res:
                return res
            board[i-1][j] = word[wi]
        if (j+1 < self.cols) and (board[i][j+1] == word[wi]):
            board[i][j+1] = '0'
            res = self.helper(board, word, i, j+1, wi+1, ln)
            if res:
                return res
            board[i][j+1] = word[wi]
        if (j > 0) and (board[i][j-1] == word[wi]):
            board[i][j-1] = '0'
            res = self.helper(board, word, i, j-1, wi+1, ln)
            if res:
                return res
            board[i][j-1] = word[wi]
        return res
                
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.rows = len(board)
        self.cols = len(board[0])
        ln = len(word)
        res = False
        for i in range(self.rows):
            for j in range(self.cols):
                if word[0] == board[i][j]:
                    board[i][j] = '0'
                    res = self.helper(board, word, i, j, 1, ln)
                    board[i][j] = word[0]
                if res:
                    break
                
            if res:
                break
        return res
