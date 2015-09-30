/* https://leetcode.com/problems/move-zeroes/ */
class MoveZeroes
{
	public static void main(String args[])
	{
		MoveZeroes solution = new MoveZeroes();
		//int[] nums = {0};
		//int[] nums = {1, 0};
		//int[] nums = {0, 1};
		//int[] nums = {0, 0, 0};
		//int[] nums = {1,0,1};
		//int[] nums = {1, 2, 3};
		int[] nums = {0, 1, 0, 3, 12};
		solution.moveZeroes(nums);

	}

	public void moveZeroes(int[] nums) 
	{
        int leftPtr = 0;
        int rightPtr = 0;
        // missing terminating condition
        while(rightPtr<nums.length && leftPtr<nums.length)
        {
        	while(rightPtr<nums.length && nums[rightPtr]==0 )
        		rightPtr++;
        	while(leftPtr<nums.length && nums[leftPtr]!=0)
        		leftPtr++;
        	//System.out.println("r: "+ rightPtr + " l: "+ leftPtr);
        	if(rightPtr<nums.length && leftPtr<nums.length && leftPtr < rightPtr)
        	{
        		nums[leftPtr]=nums[rightPtr];
        		nums[rightPtr] = 0;
        	}
        	//leftPtr++;
        	rightPtr++;
        }
        for(int num: nums)
        	System.out.print(num+"\t");
    }
}