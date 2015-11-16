/* 

Consider a larger string s1 = "abaabbabcacc" and a smaller string s2 = "abc". The power of string is defined as repetition of each character of string. So s2 to power 1 is "abc" and s2 to power 2 is "aabbcc" and s3 to power 3 is"aaabbbccc" etc. Now the question asked to find the largest power of string s2 such that it was a valid sub-sequence in s1. For example answer here is 3.
s2 to power 3 = "aaabbbccc"
s1 = "(a)b(aabb)a(bc)a(cc)"
Is there any algorithm which works in linear time to give correct answer

*/
import java.util.Arrays;
import java.util.LinkedList;
class LargestPowerSubsequence
{
	public int[] preProcessing(String s1, String s2)
	{
		int[] a = new int[s1.length()];
		for(int i=0;i<s1.length();++i)
		{
			a[i] = s2.indexOf(s1.charAt(i));
		}
		return a;
	}

	//dp(i) is the length of longest increasing subsequence which includes element a(i) as its last element
	//LS(4) = 1 + max{LS1, LS2, LS3};
	public LinkedList<Integer> findSubsequence(int[] a)
	{
		int[] dp = new int[a.length];
		int[] p = new int[a.length];
		Arrays.fill(dp, 1);
		Arrays.fill(p, -1);
		for(int i=0;i<dp.length;++i)
		{
			for(int j=0;j<i;++j)
			{
				if(a[i]>=a[j] && dp[i] < dp[j]+1)
				{
					dp[i] = dp[j] + 1;
					p[i] = j;
				}
			}
		}
		int max=1;
		int maxInd = -1;
		for(int i=0;i<dp.length;i++)
		{
			if(max < dp[i])
			{
				max = dp[i];
				maxInd = i;
			}
		}
		LinkedList<Integer> l = new LinkedList<>();
		while(true)
		{
			l.addFirst(a[maxInd]);
			maxInd = p[maxInd];
			if( maxInd == -1 )
				break;
		}
		return l;
	}

	public void print(int[] a)
	{
		for(int i: a)
			System.out.print(i+" ");
		System.out.println();
	}

	public static void main(String args[])
	{
		LargestPowerSubsequence l = new LargestPowerSubsequence();
		String s1 = "abaabbabcacc";
		String s2 = "abc";
		int[] a = l.preProcessing(s1, s2);
		//l.print(a);
		LinkedList<Integer> list = l.findSubsequence(a);
		int countMin = Integer.MAX_VALUE;
		int[] count = new int[s2.length()];
		for(int i:list)
		{
			count[i]++;
		}

		for(int i=0;i<count.length;i++)
		{
			if(count[i]<countMin)
				countMin = count[i];
		}
		System.out.println(countMin);
	}
}
