/* http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/ */
class RatMaze
{
	private static final int N = 4;
	private final int[][] maze;
	private final int[][] solution;

	public RatMaze()
	{
		maze =  new int[][]{ 
					{1, 0, 0, 0},
        			{1, 1, 0, 1},
        			{0, 1, 0, 0},
        			{1, 1, 1, 1}
    			};
    	solution = new int[N][N];
	}

	public static void main(String args[])
	{
		RatMaze ratMaze = new RatMaze();
		if(!ratMaze.solveMaze(0, 0))
			System.out.println("Solution doesn't exist");
	}

	public boolean solveMaze(int x, int y)
	{
		if(x==N-1 && y==N-1)
		{
			solution[x][y] =1;
			printSolution();
			return true;
		}
		if(isSafe(x, y))
		{
			solution[x][y] = 1;
			if(solveMaze(x, y+1))
				return true;
			if(solveMaze(x+1, y))
				return true;
			solution[x][y] = 0;
			//return false;
		}
		return false;
	}

	public boolean isSafe(int x, int y)
	{	
		if(x >=0 && x<N && y>=0 && y<N && maze[x][y]!=0)
			return true;
		return false;
	}

	public void printSolution()
	{
		for(int row=0;row<N;row++)
		{
			for(int col=0;col<N;col++)
				System.out.print(solution[row][col]+" ");
			System.out.println();
		}
		System.out.println();
	}
}