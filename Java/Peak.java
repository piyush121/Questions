class Peak
{
	public static void main(String args[])
	{
		Peak p = new Peak();
		int[] arr = {1,2,3,4,1};
		System.out.println(p.findPeak(arr));
	}
	
	public int findPeak(int[] arr)
	{
		int max = arr[0];
		int index = 0;
		for(int i = 1 ;i<arr.length-1;i++)
		{
			int prev = arr[i-1];
			int curr = arr[i];
			int next = arr[i+1];
			if(curr>prev && curr>next && curr> max)
			{
				max = curr;
				index = i;
			}
		}
		if(arr[arr.length-1]>max)
			return arr.length-1;
		return index;
	}
}