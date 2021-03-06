/* http://www.geeksforgeeks.org/median-of-two-sorted-arrays/ */

class MedianOfTwoSortedArrays
{
	public int modifiedBinarySearch(int[] a, int[] b)
	{

	}

	public int helper(int[] a, int[] b, int startA, int endA, int startB, int endB)
	{
		int medianA = startA + (endA-startA)/2;
		int medianB = startB + (endB-startB)/2;

		if(a[medianA] == b[medianB])
			return a[medianA];
		if(a[medianA] > b[medianB])
			return helper(a, b, startA, medianA-1, medianB+1, endB);
		else
			return helper(a, b, medianA+1, endA, startB, medianB-1);
	}

	public static void main(String args[])
	{
		int arr1[] = {1, 12, 15, 26, 38};
    	int arr2[] = {2, 13, 17, 30, 45};
    	MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
    	System.out.println(m.modifiedBinarySearch(arr1, arr2))
	}	
}
