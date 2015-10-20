/* https://leetcode.com/problems/house-robber/ */
import java.util.HashMap;
class HouseRobber
{
	/*int[] cache;

	public int rob(int[] num)
	{
	    cache = new int[num.length];
		for(int i=0;i<num.length;i++)
		{
			cache[i] = -1;
		}
		return helper(num, 0);
    }

	public int helper(int[] num, int i)
	{
		if(i>num.length-1)
			return 0;
		if(cache[i]!=-1)
			return cache[i];
		return cache[i] = Math.max(num[i] + helper(num, i+2), helper(num, i+1));
	}*/

	public static void main(String args[])
    {
        int[] nums = {10, 20, 11};
        HouseRobber solution = new HouseRobber();
        System.out.println(solution.rob(nums));
    }

    public int rob(int[] nums)
    {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            dp[i] = nums[i]+dp[i-2] > dp[i-1]? nums[i] + dp[i-2] : dp[i-1];
        }
        return dp[nums.length-1];
    }
}
