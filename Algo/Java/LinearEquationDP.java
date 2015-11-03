/* http://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/ */

class LinearEquationDP
{
	public int solve(int[] coeff, int rhs)
	{
		int[] dp = new int dp[rhs+1];
		Arrays.fill(dp, 0);
		//if rhs == 0 then if both coeffs are zero we will get a solution
		dp[0] = 1;

		
	}

	public static void main(String args[])
	{

	}


}