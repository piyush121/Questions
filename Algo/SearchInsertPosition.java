class SearchInsertPosition
{
	int index = -1;
	public int searchInsert(int[] A, int target)
	{
        return helper(A, target, 0, A.length-1);
    }
	
	public int helper(int[] a , int target, int lo, int hi)
	{
		if(lo>hi)
		{
			index = lo;
			return index;
		}
		int mid = lo +(hi-lo)/2;
		if(a[mid]==target)
		{	
			index = mid;
			return index;
		}
		else if(a[mid]>target)
		{
			helper(a, target, lo, mid-1);
		}
		else if(a[mid]<target)
		{
			helper(a, target,mid+1, hi);
		}
		return index;
	}
	
	public static void main(String args[])
	{
		int[] a = {1,3};
		SearchInsertPosition s = new SearchInsertPosition();
		System.out.println(s.searchInsert(a, 3));
	}
}