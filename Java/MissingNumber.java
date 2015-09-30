/* https://leetcode.com/problems/missing-number/ */
class MissingNumber
{
	public static void main(String args[])
	{
		MissingNumber solution = new MissingNumber();
		int[] nums = {0, 1, 2};
		System.out.println(solution.missingNumber(nums));
	}

	public int missingNumber(int[] nums) 
	{
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
        for(int num:nums)
        {
        	sum += num;
        	if(num > max)
        		max = num;
        	if(num < min)
        		min = num; 
        }
        if(min!=0)
        	return 0;
        else if((max-min)==nums.length-1)
        	return max+1;
        //System.out.println("min: "+min+ " max: "+ max);
        int actual_sum = ((max + min)*(nums.length+1))/2;
        //System.out.println("actual_sum: "+ actual_sum);

        return (actual_sum - sum);
    }
}