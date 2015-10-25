import java.util.Arrays;
import java.util.HashSet;
class LongestIncreasingSubsequence
{
	int max=0;
	static HashSet<String> set = new HashSet<String>();
	public int findLength(int[] a)
	{
		return helper("", a, Integer.MIN_VALUE);
	}

	public int helper(String s, int[] a, int prev)
	{
		if(a.length==0)
		{
			if(!set.contains(s))
			{
				set.add(s);
				if(s.length()>max)
					max = s.length();
			}
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>prev)
				helper(s+a[i], Arrays.copyOfRange(a, i+1, a.length), a[i]);
			else
				helper(s, Arrays.copyOfRange(a, i+1, a.length), prev);
		}
		return max;
	}

	public static void main(String args[])
	{
		int[] a = {5, 3, 2, 4, 6, 9, 8, 7};
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.findLength(a));
		System.out.println(set);
	}
}
