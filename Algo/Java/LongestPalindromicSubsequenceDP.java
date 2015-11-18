/* http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/ */

class LongestPalindromicSubsequenceDP
{
	public int getLength(String s)
	{
		int[][] dp = new int[s.length()][s.length()];
		//Strings of length 1 are palindrome of length 1
		for(int i=0;i<s.length();i++)
		{
			dp[i][i] = 1;
		}

		//i is length of the substring
		//lower diagonals are of no use eg. dp[5][1]
		for(int i=2;i<=s.length();i++)
		{
			for(int j=0;j<s.length()-i+1;j++)
			{
				int k = j+i-1;	

				if(s.charAt(j)==s.charAt(k) && i==2)
					dp[j][k] = 2;
				else if(s.charAt(j)==s.charAt(k))
					dp[j][k] = dp[j+1][k-1]+2;
				else
					dp[j][k] = Math.max(dp[j+1][k], dp[j][k-1]);
			}
		}
		return dp[0][s.length()-1];
	}

	public static void main(String args[])
	{
		LongestPalindromicSubsequenceDP l = new LongestPalindromicSubsequenceDP();
		String s = "BBABCBCAB";
		System.out.println(l.getLength(s));
	}
}