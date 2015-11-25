/* http://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/ */
/*	or magic index (CTCI)
*/

class FixedPoint
{
	public int find(int[] arr)
	{
		return findHelper(arr, 0, arr.length-1);
	}

	public int findHelper(int[] arr, int lo, int hi)
	{
		int mid = lo + (hi-lo)/2;
		if(arr[mid] == mid)
			return mid;
		if(hi>=lo)
		{
			if(mid > arr[mid])
				return findHelper(arr, mid+1, hi);
			else if (mid < arr[mid])
				return findHelper(arr, lo, mid-1);
		}
		return -1;
	}

	public static void main(String args[])
	{
		//int[] arr = {-10, -5, 0, 3, 7};
		//int[] arr = {0, 2, 5, 8, 17};
		int[] arr = {-10, -5, 3, 4, 7, 9};
		FixedPoint f = new FixedPoint();
		System.out.println(f.find(arr));
	}
}
