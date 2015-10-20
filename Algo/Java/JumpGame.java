class JumpGame
{
	public static void main(String args[])
	{
		JumpGame jg = new JumpGame();
		int A[] = {3,2,1,0,4};
		//int A[] = {2,5, 0, 0};
		//int A[] = {2,3,1,1,4};
		//int A[] = {0};
		System.out.println(jg.canJump(A));
	}

	public boolean canJump(int[] nums)
	{
		if(nums.length==1)
			return nums[0]==0?false:true;
		int lastIndex = nums.length-1;
		for(int i=nums.length-2;i>=0;i--)
		{
			if(i+nums[i] >= lastIndex)
				lastIndex = i;
    	  //return helper(0, nums);
		}
		return lastIndex == 0;
    }

    public boolean helper(int index, int[] nums)
    {
    	if(index!=nums.length-1 && nums[index]==0)
    	{
    		return false;
    	}
    	else
    	{
    		int length = nums[index];
    		while(length!=0)
    		{
    			if(nums.length-1 <= (index + length))
    				return true;
    			else
    			{
    				if(helper(index+length, nums))
    					return true;
    				length--;
    			}
    		}
    		return false;
    	}
    }
}
