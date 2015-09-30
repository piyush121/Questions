/* https://leetcode.com/problems/climbing-stairs/ */
import java.util.HashSet;
class ClimbStairs
{
	HashSet set = new HashSet();
	public int climbStairs(int n)
	{
		return helper(n, 0, "");
	}
	
	public int helper(int n, int steps, String pattern)
	{
		if(n<steps)
			return -1;
		if(n==steps)
		{
			if(!set.contains(pattern))
			{
				System.out.println(pattern);
				set.add(pattern);
			}
		}
		helper(n, steps+1, pattern+"1");
		helper(n, steps+2, pattern+"2");
		return set.size();
	}
	
	public static void main(String args[])
	{
		ClimbStairs cs = new ClimbStairs();
		//System.out.println(cs.climbStairs(10));
		System.out.println(cs.efficient(35));	
	}
	
	public static int efficient(int n)
	{
		if(n<3)
		{
			return n;
		}
		int[] m = new int[n+1];
		m[0] = 0;
		m[1] = 1;
		m[2] = 2;
		
		for(int i=3;i<=n;i++)
			m[i] = m[i-1]+m[i-2];
		
		return m[n];
	}
}