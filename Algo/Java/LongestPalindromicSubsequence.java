/* http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/ */

class LongestPalindromicSubsequence
{
	/* for eg. BBABCBCAB
	if first and last character are same 
	then x[0..n-1] = L(1, n-1) + 2
	else 
		recursively compare first and second last character 
		and second and last character
		L(0, n-1) = Max(L(1, n-2), L(2, n-1));
	*/

	public int getLength(String s)
	{
		return helper(s, 0, s.length()-1);
	}

	public int helper(String s, int start, int end)
	{
		//if start==end, then only one character to compare
		//terminating condition for the odd length strings
		if(start==end)
			return 1;

		//if only two characters are left and both are same
		//terminating condition for the even length strings
		if((s.charAt(start) == s.charAt(end)) && (start+1 == end))
			return 2;
		//if both the characters at the start and the end are same 
		// then increment the max length found so far with 2
		if(s.charAt(start)==s.charAt(end))
			return helper(s, start+1, end-1)+2;
		//if the characters at the start and end are not equal 
		//then compare the character at start with character before end 
		//compare the character after start with the character at end
		return Math.max(helper(s, start, end-1), helper(s, start+1, end));
	}

	public static void main(String args[])
	{
		LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
		String s = "BBABCBCAB";
		System.out.println(l.getLength(s));
	}
}