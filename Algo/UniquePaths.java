/* https://leetcode.com/problems/unique-paths/ */
class UniquePaths
{
	public static void main(String args[])
	{
		UniquePaths solution = new UniquePaths();
		System.out.println(solution.uniquePaths(3, 7));
	}

	public int uniquePaths(int m, int n)
	{
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				dp[i][j]=-1;
		}
		helper(m-1, n-1, dp);
		return dp[m-1][n-1];
	}

	int helper(int i, int j, int[][] dp)
	{
		if(i<0 ||j<0)
			return 0;
		if(i==0 && j==0)
		{
			return dp[i][j]=1;
		}
		else
		{
			dp[i][j] = dp[i][j]!=-1?dp[i][j]:(helper(i-1, j, dp) + helper(i, j-1, dp));
			return dp[i][j];
		}
	}
}