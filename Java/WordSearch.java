import java.util.HashSet;
public class WordSearch
{
	HashSet<Pair<Integer,Integer>> set = null;
	public boolean exist(char[][] board, String word)
	{
		if(board.length==0)
			return false;
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				if(board[i][j]==word.charAt(0))
				{
					set = new HashSet<Pair<Integer, Integer>>();
					System.out.println("i: "+i+"j: "+j);
					boolean a = helper(board, word, "",i,j, 0);
					if(a)
						return true;
				}
			}
			//System.out.println("$$$$$$$$$");
		}
        return false;
    }
	
	public boolean helper(char[][] board, String word, String temp, int rowIndex, int colIndex, int count)
	{
		
		System.out.println("temp: "+temp + " rowIndex: "+rowIndex+" colIndex: "+colIndex+" count: "+count);
		if(set.contains(new Pair<Integer,Integer>(rowIndex,colIndex)))
		{
			System.out.println("@@@@");
			return false;
		}
		if(temp.length() > word.length())
		{
			System.out.println("#####");
			return false;
		}
		if(word.equals(temp))
		{
			System.out.println("%%%%%");
			return true;
		}
		//System.out.println("temp: "+temp + " rowIndex: "+rowIndex+" colIndex: "+colIndex+" count: "+count);
		if(rowIndex<0 || rowIndex>board.length-1 || colIndex <0 || colIndex>board[rowIndex].length-1)
		{
			System.out.println("!!!!!");
			return false;
		}
		
		
		if(word.charAt(count)==board[rowIndex][colIndex])
		{
			System.out.println("^^^^^");
			//System.out.println("temp: "+temp + " rowIndex: "+rowIndex+" colIndex: "+colIndex+" count: "+count);
			count = count +1;
			temp = temp + board[rowIndex][colIndex];
			System.out.println("adding: "+ rowIndex+" "+colIndex);
			set.add(new Pair<Integer,Integer>(rowIndex,colIndex));
			System.out.println("temp: "+temp + " rowIndex: "+rowIndex+" colIndex: "+colIndex+" count: "+count);
			boolean u = helper(board, word, temp, rowIndex-1, colIndex, count);
			boolean d = helper(board, word, temp, rowIndex+1, colIndex, count);
			boolean r = helper(board, word, temp, rowIndex, colIndex-1, count);
			boolean l = helper(board, word, temp, rowIndex, colIndex+1, count);
			if(u||d||r||l)
			{
				System.out.println("*****");
				return true;
			}
		}
		//count--;
		//set.remove(new Pair<Integer, Integer>(rowIndex, rowIndex));
		System.out.println("&&&&&");
		return false;
	}
	
	public static void main(String args[])
	{
		WordSearch ws = new WordSearch();
		char[][] board = {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'E', 'S'},
			{'A', 'D', 'E', 'E'}
		};
		//char[][] board = {{'c','a','a'}, 
		//				{'a','a','a'},
		//				{'b','c','d'}};
		//System.out.println(ws.exist(board, "ABCCED"));
		//System.out.println(ws.exist(board, "SEE"));
		System.out.println(ws.exist(board, "ABCESEEEFS"));
	}
}

class Pair<L,R>
{
	L left;
	R right;
	Pair(L left, R right)
	{
		this.left = left;
		this.right = right;
	}
	@Override
	public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    @SuppressWarnings("rawtypes")
    Pair other = (Pair) obj;
    if (this.left == null) {
      if (other.left != null) {
        return false;
      }
    } else if (!this.left.equals(other.left)) {
      return false;
    }
    if (this.right == null) {
      if (other.right != null) {
        return false;
      }
    } else if (!this.right.equals(other.right)) {
      return false;
    }
    return true;
  }
	
	@Override
	public int hashCode() 
	{
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.left == null) ? 0 : this.left.hashCode());
    result = prime * result + ((this.right == null) ? 0 : this.right.hashCode());
    return result;
  }
}