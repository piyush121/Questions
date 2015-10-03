/* https://leetcode.com/problems/word-search/ */
import java.util.Arrays;
class WordSearch
{
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
		boolean[][] visited = new boolean[board.length][board[0].length];
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
	public boolean existHelper(int i, int j, char[][] board, String word, int pos, boolean[][] visited) 
	{
		if(pos==word.length())
			return true;
        if(isSafe(i, j, board, word, pos, visited))
        {
        	//System.out.println("row: "+i+" col: "+j+" pos: "+pos);
        	visited[i][j] = true;
        	if(existHelper(i+1, j, board, word, pos+1, visited))
        		return true;
        	if(existHelper(i, j+1, board, word, pos+1, visited))
        		return true;
        	if(existHelper(i-1, j, board, word, pos+1, visited))
        		return true;
        	if(existHelper(i, j-1, board, word, pos+1, visited))
        		return true;
        	visited[i][j] = false;
        }
        return false;
    }

    public boolean isSafe(int row, int col, char[][] board, String word, int pos, boolean [][] visited)
    {
    	if(row<board.length && row>=0 && col < board[row].length && col >=0 && visited[row][col]!=true && board[row][col]==word.charAt(pos))
    		return true;
    	return false;
    }
}