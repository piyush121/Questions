/* http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/ */
import java.util.Arrays;

class SubsetSumDP
{
	public boolean isSubsetSum(int[] set, int sum)
	{
		// The value of subset[i][j] will be true if there is a subset of set[0..j-1]
    	//  with sum equal to i
		boolean[][] dp = new boolean[sum+1][set.length+1];
		Arrays.fill(dp[0], true);
		for(int i=0;i<=set.length;i++)
			dp[i][0] = false;

		for(int i=1;i<=sum;i++)
		{
			for(int j=1;j<=set.length;j++)
			{
				//if the jth element is not included
				dp[i][j] = dp[i][j-1];
				if(i>=set[j-1])
				{
					//either jth element id not included then dp[i][j] = dp[i][j-1]
					//or it is included then dp[i][j] = dp[i-set[j-1]][j]
					dp[i][j] = dp[i][j] || dp[i-set[j-1]][j];
				}
			}
		}
		return dp[sum][set.length];

	}

	public static void main(String args[])
	{
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;

		SubsetSumDP s = new SubsetSumDP();
		System.out.println(s.isSubsetSum(set, sum));
	}
}