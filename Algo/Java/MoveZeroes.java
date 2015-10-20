/* https://leetcode.com/problems/move-zeroes/ */
class MoveZeroes
{
	public static void main(String args[])
	{
		MoveZeroes solution = new MoveZeroes();
		// int[] nums = {0};
		// int[] nums = {1, 0};
		// int[] nums = {0, 1};
		// int[] nums = {0, 0, 0};
		// int[] nums = {1,0,1};
		// int[] nums = {1, 2, 3};
		int[] nums = {0, 1, 0, 3, 12};
		solution.moveZeroes(nums);

	}

	public void moveZeroes(int[] nums)
	{
			int ptr = 0;
			int i = 0;
			while(i<nums.length){
				if(nums[i]!=0){
					nums[ptr++] = nums[i];
				}
				i++;
			}
			while(ptr<nums.length){
				nums[ptr++] = 0;
			}
      for(int num: nums)
        System.out.print(num+"\t");
    }
}
