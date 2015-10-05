import java.util.Arrays;
class Max
{
	public static int findMax(int[] a)
	{
		if(a.length==1)
			return a[0];
		else
		{
			//max of a[0] and rest of array
			return Math.max(a[0], findMax(Arrays.copyOfRange(a, 1, a.length)));
		}
	}

	public static int findMax1(int[] a, int lo, int hi)
	{
		if(lo>=hi)
		{
			return a[lo];
		}
		else
		{
			int mid = lo + (hi-lo)/2;
			return Math.max(findMax1(a,lo,mid), findMax1(a,mid+1,hi));
		}
	}

	public static void main(String args[])
	{
		int[] a = {100,10, 40, 20, 70, 50, 30,80,100};
		System.out.println(Max.findMax(a));
		System.out.println(Max.findMax1(a, 0, a.length-1));
	}



}
