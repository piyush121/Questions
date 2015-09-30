/* https://leetcode.com/problems/maximum-subarray/ */
class MaximumSubarray
{
	public static void main(String args[])
	{
		MaximumSubarray ms = new MaximumSubarray();
		//int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int nums[] = {-2, -1};
		System.out.println(ms.maxSubArray(nums));
	}

	public int maxSubArray(int[] nums)
	{
		int[] dp = new int[nums.length];
		dp[0] = nums[0];

		int max = dp[0];
		for(int i=1;i<nums.length;i++)
		{
			dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
			//dp[i] = dp[i]<0?0:dp[i];
			max = Math.max(dp[i], max);
		}
		return max;
	}
}