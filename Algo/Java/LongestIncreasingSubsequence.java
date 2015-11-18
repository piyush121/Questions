/* https://leetcode.com/problems/longest-increasing-subsequence/ */
import java.util.Arrays;
class LongestIncreasingSubsequence
{
	public int lengthOfLIS(int[] nums) 
	{
		if(nums==null || nums.length==0)
			return 0;
		if(nums.length==1)
			return 1;
    	int[] dp = new int[nums.length];
    	Arrays.fill(dp, 1);
    	int max = Integer.MIN_VALUE;
    	for(int i=0;i<nums.length;i++)
    	{
    		for(int j=0;j<i;j++)
    		{
    			if(nums[i] > nums[j] && dp[j]+1 > dp[i])
    				dp[i] = dp[j]+1;
    		}
    	} 
    	for(int i=0;i<dp.length;i++)
    	{
    		if(dp[i]>max)
    			max = dp[i];
    	}

    	return max;
    }
	
	public static void main(String args[])
	{
		int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS(a));
	}
}
