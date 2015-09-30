/* https://leetcode.com/problems/sudoku-solver/ */

class SudokuSolver
{
	private static final int N = 9;
	private char[][] sudoku;
	public SudokuSolver()
	{
		//empty cells are indicated by '.'
		for(int r=0;r<N;r++)
			for(int c=0;c<N;c++)
				sudoku[r][c] = '.';
		
		//sudoku = ;//initialize sudoku
	}

	private boolean isSafe(int row, int col, char c)
	{
		if(isSafeRow(row, col, c) && isSafeCol(row, col, c) && isSafeBox(row, col, c))
			return true;
		return false;
	}

	private boolean isSafeRow(int row, int col, char c)
	{
		for(int i=0;i<N;i++)
		{
			if(sudoku[row][i]==c)
				return false;
		}
		return true;
	}

	private boolean isSafeCol(int row, int col, char c)
	{
		for(int i= 0;i<N;i++)
		{
			if(sudoku[i][col]==c)
				return false;
		}
		return true;
	}

	private boolean isSafeBox(int row, int col, char a)
	{
		int boxRow = row - row%3;
		int boxCol = col - col%3;

		for(int r=0;r<Math.sqrt(N);r++)
		{
			for(int c=0;c<Math.sqrt(N);c++)
			{
				if(sudoku[boxRow + r][boxCol +c] == a)
					return false;
			}
		}
		return true;
	}

	private boolean findUnassigned(int[] empty)
	{
		empty[0] = -1;
		empty[1] = -1;
		for(int r=0;r<N;r++)
		{
			for(int c=0;c<N;c++)
			{
				if(sudoku[r][c]=='.')
				{
					empty[0] = r;
					empty[1] = c;
					return true;
				}
			}
		}
		return false;
	}

	public boolean solve()
	{
		int[] empty = new int[2];
		if(!findUnassigned(empty))
			return true;
		int row = empty[0];
		int col = empty[1];
		for(char i='1';i<='9';i++)
		{
			if(isSafeRow(row, col, i))
			{
				sudoku[row][col] = i;
				if(solve())
					return true;
				sudoku[row][col] = '.';
			}
		}	
		return false;
	}

	public static void main(String args[])
	{	
		SudokuSolver ss = new SudokuSolver();

	}

}