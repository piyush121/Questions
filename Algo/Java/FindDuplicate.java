/* https://leetcode.com/problems/find-the-duplicate-number/ */
import java.util.Arrays;

class FindDuplicate
{
	public int findDuplicate(int[] nums) 
	{
       Arrays.sort(nums);
       return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int lo, int hi)
    {
    	int mid = lo + (hi-lo)/2;

    }

    public static void main(String args[])
    {
    	FindDuplicate f = new FindDuplicate();
    	int[] a = {1,2,3,4,1};
    	System.out.println(f.findDuplicate(a));
    }
}