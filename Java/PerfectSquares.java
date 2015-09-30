/* https://leetcode.com/problems/perfect-squares/ */
class PerfectSquares
{
	public static void main(String args[])
	{
		PerfectSquares ps = new PerfectSquares();
		System.out.println(ps.numSquares(12));
	}

	public int numSquares(int n)
	{
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++)
        {
        	int min = Integer.MAX_VALUE;
        	for(int j=1;j<=(int)Math.sqrt(i);j++)
        	{
        		min = Math.min(min, dp[i - j*j]+1);
        	}
        	dp[i] = min;
        }
        return dp[n];
    }
}