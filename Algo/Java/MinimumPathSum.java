/* https://leetcode.com/problems/minimum-path-sum/ */
class MinimumPathSum
{
	public static void main(String args[])
	{
		int[][] grid = {{1,  2,  32},
						{8,  16, 16},
						{1,  1,  1}};
		MinimumPathSum solution = new MinimumPathSum();
		System.out.println(solution.minPathSum(grid));
	}

	public int minPathSum(int[][] grid)
	{
		int m = grid.length;
        int n = grid[grid.length-1].length;
		int[][] dp = new int[m][n];

		dp[0][0] = grid[0][0];
		int max = Integer.MAX_VALUE;
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[grid.length-1].length;j++)
			{
				int leftSum = j>0?dp[i][j-1]:max;
				int topSum = i>0?dp[i-1][j]:max;
				if(i==0 && j==0)
					continue;
				dp[i][j] = grid[i][j] + ((leftSum>topSum)?topSum:leftSum)	;
			}
		}
		return dp[m-1][n-1];
	}

	public int minPathSumI(int[][] grid) //Recursive - time limit exceeded
	{
        int m = grid.length;
        int n = grid[grid.length-1].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		dp[i][j] = -1;
        	}
        }
        helper(m-1, n-1, grid, dp);

        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		System.out.print(dp[i][j]+"\t");
        	}
        	System.out.println();
        }
        return dp[m-1][n-1];
    }

    int helper(int i, int j, int[][] grid, int[][] dp)
    {
    	if(i<0 || j<0)
    		return Integer.MAX_VALUE;
    	if(i==0 && j==0)
    	{
    		dp[i][j] = grid[i][j];
    		return dp[i][j];
    	}
    	else
    	{
    		dp[i][j] = (dp[i][j]!=-1? dp[i][j] : grid[i][j]+Math.min(helper(i-1, j, grid, dp), helper(i, j-1, grid, dp)));
    		return dp[i][j];
    	}
    }
}
