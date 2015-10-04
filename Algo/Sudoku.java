import java.util.HashSet;
class Sudoku
{
	public boolean isValidSudoku(char[][] board)
	{
		//check board length
		if(board.length != 9 || board[0].length!=9) return false;
        //check rows for duplicacy
		for(int row=0;row<9;row++)
		{
			HashSet<Character> rows = new HashSet<Character>();
			for(int col=0;col<9;col++)
			{
				if(board[row][col]!='.')
				{
					if(rows.contains(board[row][col])) return false;
					else rows.add(board[row][col]);
				}
			}
		}
		for(int col=0;col<9;col++)
		{
			HashSet<Character> cols = new HashSet<Character>();
			for(int row=0;row<9;row++)
			{
				if(board[row][col]!='.')
				{
					if(cols.contains(board[row][col])) return false;
					else cols.add(board[row][col]);
				}
			}
		}

		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				HashSet<Character> box = new HashSet<Character>();
				for(int row=0;row<3;row++)
				{
					for(int col=0;col<3;col++)
					{
						if(board[i*3 + row][j*3+ col]!='.')
						{
							if(box.contains(board[i*3 + row][j*3+ col])) return false;
							else box.add(board[i*3 + row][j*3+ col]);
						}
					}
				}
			}
		}
		return true;
    }

	public static void main(String args[])
	{
		Sudoku s = new Sudoku();
		//char[]
		System.out.println();
	}
}
