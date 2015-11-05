/* http://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/ */

class CountWaysToCoverDistanceDP
{

	public int count(int dist)
	{
		int[] dp = new int[dist+1];
		//dp[i] indicate the number of ways distance i can be covered using 
		// 1, 2 or 3 steps
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for(int i=3;i<=dist;i++)
		{
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		return dp[dist];
	}

	public static void main(String args[])
	{
		int dist = 4;
		CountWaysToCoverDistanceDP c = new CountWaysToCoverDistanceDP();
		System.out.println(c.count(dist));
	}
}