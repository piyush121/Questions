class SearchARange
{
	public int[] searchRange(int[] A, int target)
	{
        int[] range = {A.length, -1};
		range = helper(A, target, 0, A.length-1, range);
		if(range[1]==-1)
		{
			range[0] = -1;
		}
		return range;
    }

	public int[] helper(int[] a, int target, int lo, int hi, int[] range)
	{
		if(lo>hi)
			return range;
		int mid = lo+(hi-lo)/2;
		if(a[mid]==target)
		{
			System.out.println(mid+" "+range[0]+" "+range[1]);
			if(mid<range[0])
			{
				range[0] = mid;
				helper(a, target, lo, mid-1, range);
			}
			if(mid>range[1])
			{
				range[1] = mid;
				helper(a, target, mid+1, hi, range);
			}
		}
		else if(a[mid] < target)
		{
			helper(a, target, mid+1, hi, range);
		}
		else if(a[mid] > target)
		{
			helper(a, target, lo, mid-1, range);
		}
		return range;
	}

	public static void main(String args[])
	{
		SearchARange s = new SearchARange();
		int[] A = {5, 7, 7, 8, 8, 10};
		int target = 0;
		int[] range = s.searchRange(A, target);
		System.out.println(range[0]+" "+range[1]);
	}
}
