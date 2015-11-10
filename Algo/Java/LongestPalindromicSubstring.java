/* http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/ */
import java.util.Arrays;
class LongestPalindromicSubstring
{
	public int longestPalindromicSubstring(String s)
	{
		int l = s.length();
		
		//indicate maximum length of the palindrome found so far
		int maxLength=1;
		
		//dp[i][j] is true if substring is palindrome
		boolean dp[][] = new boolean[l][l];
		for(int i=0;i<l;i++)
			Arrays.fill(dp[i], false);

		// all substring of length 1 are palindrome
		for(int i=0;i<l;i++)
			dp[i][i] = true;

		//starting index of the palindromic substring
		int start = 0;
		//check substring of length 2
		for(int i=0; i<l-1;i++)
		{
			if(s.charAt(i) == s.charAt(i+1))
			{
				dp[i][i+1] = true;
				maxLength = 2;
				start = i;
			}
		}

		//check the substring of length greater than 2
		//i denote the length of the string
		for(int i=3; i<=l; i++)
		{
			//creating window of size i
			for(int j=0;j<l-i+1;j++)
			{
				//ending index of the substring with window size i
				int k = j + i - 1;
				//check the substring from jth index to kth index is palindrome
				//for eg : current window contains geekkeeg
				//we are checking whether the substring eekkee is palindrome 
				if(dp[j+1][k-1]==true && s.charAt(j) == s.charAt(k))
				{
					dp[j][k] =  true;
					if(i > maxLength)
					{
						start = j;
						maxLength = i;
					}
				}
			}
		}
		System.out.println("Longest Palindromic Substring: "+ s.substring(start, start+maxLength));
		return maxLength;
	}


	public static void main(String args[])
	{
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		String str = "forgeeksskeegfor";
		System.out.println(l.longestPalindromicSubstring(str));
	}
}