class MinimumRotated
{
	public static void main(String args[])
	{
		MinimumRotated mr = new MinimumRotated();
		int[] arr1 = {6,7,0,1,2,4,5};
		int[] arr2 = {0, 1, 2, 4, 5, 6, 7};
		int[] arr3 = {4, 5, 6, 7, 0, 1, 2};
		int[] arr4 = {99, 82, 83, 84, 86};
		System.out.println(mr.findMin(arr1, 0 , arr1.length-1));
		System.out.println(mr.findMin(arr2, 0, arr2.length-1));
		System.out.println(mr.findMin(arr3, 0, arr3.length-1));
		System.out.println(mr.findMin(arr4, 0, arr4.length-1));
	}

	public int findMin(int[] nums)
	{
		return helper(nums, 0, nums.length-1);
	}

	public int helper(int[] arr, int low, int high)
	{
		if(low==high)
		{
			return arr[high];
		}

		if(Math.abs(low-high) == 1)
		{
			return Math.min(arr[low], arr[high]);
		}

		int mid = low + (high-low)/2;
		if (arr[low]<arr[high])
		{
			return arr[low];
		}
		else if(arr[low]<arr[mid])
		{
			return helper(arr, mid, high);
		}
		else
		{
			return helper(arr, low, mid);
		}
	}
}
