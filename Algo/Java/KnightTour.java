/* http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/ */
import java.util.Arrays;
public class KnightTour
{
	public static void main(String args[])
	{
		KnightTour k = new KnightTour();
		k.tour(8);
	}

	public boolean tour(int boardSize)
	{
		int[][] board  = new int[boardSize][boardSize];
		//http://stackoverflow.com/questions/19372622/how-do-i-generate-all-of-a-knights-moves
		//to calculate the next move of the knight from the 
		//current position 
		// for example current position is (1,3)
		//possible moves are (1+2, 3+1), (1+1, 3+2), (1-1, 3+2) and so on
		int[] xMoves = {2, 1, -1, -2, -2, -1,  1,  2 };
		int[] yMoves = {1, 2,  2,  1, -1, -2, -2, -1};
		//initialize the cells with -1
		for(int i=0;i<board.length;i++)
		{
			Arrays.fill(board[i], -1);
		}
		board[0][0] = 0;
		//if tourHelper return false then there is no solution 
		//return false
		if(!tourHelper(0, 0, 1, board, xMoves, yMoves))
		{
			System.out.println("Solution doesn't exist");
			return false;
		}
		else
			printBoard(board);
		return true;

	}

	private boolean tourHelper(int x, int y, int count, int[][] board, int[] xMoves, int[] yMoves)
	{
		int N = board.length;
		//terminating condition : when the count is equals to 64
		if(count == N * N)
			return true;
		//check all the possible moves
		for(int i=0;i<N;i++)
		{
			//calculate the next move
			int x_next = x + xMoves[i];
			int y_next = y + yMoves[i];
			//check if it is safe to take the next move
			//where safe means the cells is not visited yet
			//and the next position does not lie outside the board
			if(isSafe(x_next, y_next, board))
			{
				board[x_next][y_next] = count;
				if(tourHelper(x_next, y_next, count+1, board, xMoves, yMoves))
					return true;
				board[x_next][y_next] = -1;//backtracking
			} 
		}
		return false;
	}

	private boolean isSafe(int xPos, int yPos, int[][] board)
	{
		int N = board.length;
		//check if the position hasn't already visited 
		//and should lie on the chess board
		if(xPos > -1 && xPos < N && yPos > -1 && yPos < N && board[xPos][yPos]==-1)
		{
			return true;
		}
		return false;
	}
	//print the solution 
	private void printBoard(int[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	} 
}