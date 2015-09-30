/* https://leetcode.com/problems/sudoku-solver/ */

class SudokuSolver
{
	private static final int N = 9;
	private char[][] sudoku;
	public SudokuSolver()
	{
		sudoku = new char[N][N];
		//empty cells are indicated by '.'
		for(int r=0;r<N;r++)
			for(int c=0;c<N;c++)
				sudoku[r][c] = '.';
		
		sudoku[0][0] = '5';
		sudoku[0][1] = '3';
		sudoku[0][4] = '7';
		sudoku[1][0] = '6';
		sudoku[1][3] = '1';
		sudoku[1][4] = '9';
		sudoku[1][5] = '5';
		sudoku[2][1] = '9';
		sudoku[2][2] = '8';
		sudoku[2][7] = '6';
		sudoku[3][0] = '8';
		sudoku[3][4] = '6';
		sudoku[3][8] = '3';
		sudoku[4][0] = '4';
		sudoku[4][3] = '8';
		sudoku[4][5] = '3';
		sudoku[4][8] = '1';
		sudoku[5][0] = '7';
		sudoku[5][4] = '2';
		sudoku[5][8] = '6';
		sudoku[6][1] = '6';
		sudoku[6][6] = '2';
		sudoku[6][7] = '8';
		sudoku[7][3] = '4';
		sudoku[7][4] = '1';
		sudoku[7][5] = '9';
		sudoku[7][8] = '5';
		sudoku[8][4] = '8';
		sudoku[8][7] = '7';
		sudoku[8][8] = '9';
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

	private void printSudoku()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				System.out.print(sudoku[i][j]+" ");
			System.out.println();
		}
		
	}

	public static void main(String args[])
	{	
		SudokuSolver ss = new SudokuSolver();
		ss.solve();
		ss.printSudoku();
	}

}