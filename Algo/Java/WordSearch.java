/* https://leetcode.com/problems/word-search/ */
import java.util.Arrays;
class WordSearch
{
	//the idea is to use backtracking to search for a given word in a grid
	public static void main(String args[])
	{
		char[][] board = {
 							{'A','B','C','E'},
  							{'S','F','C','S'},
  							{'A','D','E','E'}
						};
		WordSearch ws = new WordSearch();
		String word = "SEE";
		System.out.println(ws.exist(board, word));
	}

	public boolean exist(char[][] board, String word)
	{
		//@visited to keep track of the visited cells
		boolean[][] visited = new boolean[board.length][board[0].length];
		//initialize visited with false
		for(int i=0;i<board.length;i++)
			Arrays.fill(visited[i], false);
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				//System.out.println("-----------");
				if(existHelper(i, j, board, word, 0, visited))
					return true;
			}
		}
		return false;
	}

	//Backtracking
	//@pos: number of characters to matched so far
	//@i, @j current position in the grid
	public boolean existHelper(int i, int j, char[][] board, String word, int pos, boolean[][] visited)
	{
		//if the number of characters matched is equal to length of the word
		//then return true
		if(pos==word.length())
			return true;

		//if the next postion is safe to move
        if(isSafe(i, j, board, word, pos, visited))
        {
        	//System.out.println("row: "+i+" col: "+j+" pos: "+pos);
        	//updated cell(i,j) in visited to true
        	visited[i][j] = true;
        	//check the cell in the downward direction
        	if(existHelper(i+1, j, board, word, pos+1, visited))
        		return true;
        	//check the cell at the right
        	if(existHelper(i, j+1, board, word, pos+1, visited))
        		return true;
        	//check the cell at the left
        	if(existHelper(i-1, j, board, word, pos+1, visited))
        		return true;
        	//check the cell in the upward direction
        	if(existHelper(i, j-1, board, word, pos+1, visited))
        		return true;
        	//if the current move is not possible
        	//backtrack
        	visited[i][j] = false;
        }
        return false;
    }

    //to check if the next position is safe to move
    public boolean isSafe(int row, int col, char[][] board, String word, int pos, boolean [][] visited)
    {
    	if(row<board.length && row>=0 && col < board[row].length && col >=0 && visited[row][col]!=true && board[row][col]==word.charAt(pos))
    		return true;
    	return false;
    }
}
