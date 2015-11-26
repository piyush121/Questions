/* http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/ */

class KnapsackDP
{
	// Recursive
	public int solve(int[] value, int[] weight, int w)
	{
		return helper(value, weight, w, 0);
	}

	public int helper(int[] value, int[] weight, int w, int i)
	{
		if(i>=value.length)
			return 0;
		if(weight[i] > w)
			return helper(value, weight, w, i+1);
		else
			return Math.max(value[i]+helper(value, weight, w-weight[i], i+1), helper(value, weight, w, i+1));
	}

	//DP
	public int solveDP(int[] value, int[] weight, int w)
	{
		int[][] dp = new int[value.length+1][w+1];
		for(int i=0; i<=value.length; i++)
		{
			for(int j=0; j<=w; j++)
			{
				if(i==0 || j==0)
					dp[i][j] = 0;
				else
				{
					if(weight[i-1] <= j)
						dp[i][j] = Math.max(value[i-1] + dp[i-1][j-weight[i-1]], dp[i-1][j]);
					else
						dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[value.length][w];
	}

	public static void main(String args[])
	{
		int value[] = {60, 100, 120};
    	int weight[] = {10, 20, 30};
    	int w = 50;
    	KnapsackDP k = new KnapsackDP();
    	System.out.println(k.solveDP(value, weight, w));
	}
}