class RotateArray
{
	public void rotate(int[] nums , int k)
	{
		if(nums.length==1)
        {
            return;
        }
        int[] n = new int[nums.length];
		k = k%nums.length;
		for(int i=0;i<nums.length;i++)
		{
			if(nums.length-k+i<nums.length)
			{
				n[i] = nums[nums.length-k+i];
			}
			else
			{
				n[i] = nums[(nums.length-k+i) % nums.length];
			}
		}
		for(int i=0;i<nums.length;i++)
		{
		    nums[i] = n[i];
		}
		printArray(n);
	}

	public void efficientRotate(int[] nums, int k) {
    k = k % nums.length;
    int[] head = Arrays.copyOfRange(nums, 0, nums.length - k);
    int[] tail = Arrays.copyOfRange(nums, nums.length - k, nums.length);
    System.arraycopy(tail, 0, nums, 0, tail.length);
    System.arraycopy(head, 0, nums, k, head.length);
}

	public void printArray(int[] n)
	{
		for(int num : n)
			System.out.print(num+"\t");
	}

	public static void main(String args[])
	{
		RotateArray rt = new RotateArray();
		int[] nums = {1,2};
		rt.rotate(nums, 3);

	}
}
