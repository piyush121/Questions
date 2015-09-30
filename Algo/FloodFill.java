class FloodFill
{
	public void floodFill(int[][] screen, int x, int y, int newC)
	{
		int prevC = screen[x][y];
		helper(screen, x, y, prevC, newC);
		for(int i=0;i<screen.length;i++)
		{
			for(int j=0;j<screen[screen.length-1].length;j++)
			{
				System.out.print(screen[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void helper(int[][] screen, int x, int y, int prevC, int newC)
	{
		if(x>=screen.length || y>=screen[screen.length-1].length || x <0 || y<0)
			return;
		if(screen[x][y]!=prevC)
			return;
		screen[x][y] = newC;
		helper(screen, x+1, y, prevC, newC);
		helper(screen, x-1, y, prevC, newC);
		helper(screen, x, y+1, prevC, newC);
		helper(screen, x, y-1, prevC, newC);
	}
	
	public static void main(String args[])
	{
		FloodFill ff = new FloodFill();
		int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                     };
		int x = 4, y = 4, newC = 3;
		ff.floodFill(screen , x, y , 3);
		
	}
}