/* https://leetcode.com/problems/game-of-life/ */

class GameOfLife
{
	public static void main(String args[])
	{
		int[][] board = {
							{1, 1, 1},
							{1, 0, 0},
							{0, 0, 0}
						};
		GameOfLife g = new GameOfLife();
		g.gameOfLife(board);
		for(int[] row: board)
		{
			for(int col: row)
				System.out.print(col);
			System.out.println();
		}

	}

	public void gameOfLife(int[][] board) 
	{
		 if(board.length!=0 && board[board.length-1].length!=0)
        	getNextState(board, 0, 0);
    }

    public void getNextState(int [][] board, int i, int j)
    {
    	int row = board.length;
    	int col = board[board.length-1].length;

    	int countLiveNeighbors = 0;
    	int countDeadNeighbors = 0;
    	int nextState = -1;

    	if(i>row-1)
    		return;
    	if(i+1<row )
    	{
    		if(board[i+1][j]==1)countLiveNeighbors++;
    	}
    	if(i-1>-1)
    	{
    		if(board[i-1][j]==1)countLiveNeighbors++;
    	}
    	if(j+1<col)
    	{
    		if(board[i][j+1]==1)countLiveNeighbors++;
    	}
    	if(j-1>-1)
    	{
    		if(board[i][j-1]==1)countLiveNeighbors++;
    	}
    	if(i-1>-1 && j-1 >-1)
    	{
    		if(board[i-1][j-1]==1)countLiveNeighbors++;
    	}
    	if(i+1<row && j-1 >-1)
    	{
    		if(board[i+1][j-1]==1)countLiveNeighbors++;
    	}
    	if(i-1>-1 && j+1 < col)
    	{
    		if(board[i-1][j+1]==1)countLiveNeighbors++;
    	}
    	if(i+1<row && j+1 < col)
    	{
    		if(board[i+1][j+1]==1)countLiveNeighbors++;
    	}
    	if(board[i][j]==1)
    	{
    		if(countLiveNeighbors<2)
    			nextState = 0;
    		else if(countLiveNeighbors >= 2 && countLiveNeighbors <= 3)
    			nextState = 1;
    		else if(countLiveNeighbors > 3) 
    			nextState = 0;
    	}
    	else
    	{
    		if(countLiveNeighbors==3)
    			nextState = 1;
    		else
    			nextState = 0;
    	}
    	// System.out.println(nextState);
    	if(j+1==col)
    		getNextState(board, i+1, 0);
    	else
    		getNextState(board, i, j+1);

    	board[i][j]=nextState;
    }
}