/* https://leetcode.com/problems/range-sum-query-immutable/ */

class RangeSumQueryImmutable
{
	int[] sum;
 	public RangeSumQueryImmutable(int[] nums) 
 	{
 		if(nums!=null && nums.length!=0)
 		{
 			this.sum = new int[nums.length];
 			sum[0] =  nums[0];
        	for(int i=1;i<nums.length;i++)
        	{
        		sum[i] = sum[i-1] +nums[i];
        	}
 		}
    }

    public int sumRange(int i, int j) 
    {
    	int temp = 0;
        if(i==0)
        	return sum[j];
        return sum[j]-sum[i-1];
    }

	public static void main(String args[])
	{
		int[] nums = {-2, 0, 3, -5, 2, -1};
		RangeSumQueryImmutable r = new RangeSumQueryImmutable(nums);
		System.out.println(r.sumRange(0, 2));
		System.out.println(r.sumRange(2, 5));
		System.out.println(r.sumRange(0, 5));
	}
}