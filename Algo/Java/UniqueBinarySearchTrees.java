/* https://leetcode.com/problems/unique-binary-search-trees/ */

class UniqueBinarySearchTrees
{
	public static void main(String args[])
	{
		UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
		System.out.println(solution.numTrees(4));
	}

	public int numTrees(int n)
	{
		if(n<=0)
			return 1;
		int dp[] = new int[n+1];
		dp[0] = 1;
		for(int i=1;i<=n;i++)
		{
			dp[n] = dp[n] + helper(dp, i-1) * helper(dp, n-i);
		}
		return dp[n];
    }

    int helper(int[] dp, int n)
    {
    	if(dp[n]!=0)
    		return dp[n];
    	else
    	{
    		for(int i=1;i<=n;i++)
    			dp[n] = dp[n] + helper(dp, i-1) * helper(dp, n-i);
    	}
    	return dp[n];
    }
}
