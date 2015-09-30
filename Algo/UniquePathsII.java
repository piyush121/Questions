/* https://leetcode.com/problems/unique-paths-ii/ */
class UniquePathsII
{
	public static void main(String args[])
	{
		int[][] obstacleGrid = {{0, 0, 0},
								{0, 1, 1},
								{0, 1, 0}};
		UniquePathsII solution = new UniquePathsII();
		System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		int m = obstacleGrid.length;
		int n = obstacleGrid[obstacleGrid.length-1].length;
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				dp[i][j]=-1;
		}
		helper(m-1, n-1, dp, obstacleGrid);
		return dp[m-1][n-1]==-1?0:dp[m-1][n-1];
	}

	int helper(int i, int j, int[][] dp, int[][] obstacleGrid)
	{
		if(i<0 ||j<0 || obstacleGrid[i][j]==1)
			return 0;
		if(i==0 && j==0)
		{
			return dp[i][j]=1;
		}
		else
		{
			dp[i][j] = dp[i][j]!=-1?dp[i][j]:(helper(i-1, j, dp, obstacleGrid) + helper(i, j-1, dp, obstacleGrid));
			return dp[i][j];
		}
	}
}