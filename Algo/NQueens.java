/* https://leetcode.com/problems/n-queens/ */

class NQueens
{
	private static final int N = 8;
	private int[][] board;

	public NQueens()
	{
		board = new int[N][N];
	}

	public static void main(String args[])
	{
		NQueens n = new NQueens();
		for(int i=0;i<N;i++)
		{
			n.solve(i,8);
			n.clearBoard();
		}
	}

	public boolean isSafe(int x, int y)
	{
		if(isSafeRow(x, y)  && isSafeUpperDiagonal(x, y) && isSafeLowerDiagonal(x, y))
			return true;
		return false;
	}

	private boolean isSafeRow(int r, int c)
	{
		for(int i=0;i<N;i++)
		{
			if(board[r][i]==1)
				return false;
		}
		return true;
	}
	//NorthWest diagonal
	private boolean isSafeUpperDiagonal(int r, int c)
	{
		for(int row=r, col=c; row>=0 && col>=0;row--, col--)
		{
			if(board[row][col]==1)
				return false;
		}
		return true;
	}

	//SouthWest Diagonal
	private boolean isSafeLowerDiagonal(int r, int c)
	{
		for(int row=r, col=c;col>=0 && row<N;row++,col--)
		{
			if(board[row][col]==1)
					return false;
		}
		return true;
	}

	public boolean solve(int col, int count)
	{
		if(count==0)
		{
			printBoard();
			//clearBoard();
			return true;
		}
		for(int row = 0;row<N;row++)
		{
			if(isSafe(row, col))
			{
				board[row][col] = 1;
				if(solve((col+1)%N, count-1))
					return true;
				board[row][col] = 0;
				//return false;
			}
		}
		return false;
	}

	public void printBoard()
	{
		for(int[] row: board)
		{
			for(int col: row)
			{
				System.out.print(col+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void clearBoard()
	{
		board = new int[N][N];
	}
}
