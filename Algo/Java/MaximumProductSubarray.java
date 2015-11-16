/* http://www.geeksforgeeks.org/maximum-product-subarray/ */
/* https://leetcode.com/problems/maximum-product-subarray/ */

class MaximumProductSubarray
{
	public int maxProduct(int[] nums) 
	{
        int localMax = 1;
        int localMin = 1;
        int globalMax = 1;
        for(int i=0; i<nums.length; i++)
        {
        	if(nums[i] > 0)
        	{
        		localMax = localMax * nums[i];
        		localMin = Math.min(localMin * nums[i], 1);
        	}
        	else if(nums[i]==0)
        	{
        		localMax = 1;
        		localMin = 1;
        	}
        	else if(nums[i] < 0)
        	{
        		int temp = localMax;
        		localMax = Math.max(localMin * nums[i], 1);
        		localMin = temp * nums[i];
        	}
        	if(localMax > globalMax)
        	{
        		globalMax = localMax;
        	}
        }
        return globalMax;
    }

    public static void main(String args[])
    {
    	MaximumProductSubarray m = new MaximumProductSubarray();
    	//int arr[] = {6, -3, -10, 0, 2};
    	//int arr[] = {-1, -3, -10, 0, 60};
    	int arr[] = {-2, -3, 0, -2, -40};
    	System.out.println(m.maxProduct(arr));
    }
}