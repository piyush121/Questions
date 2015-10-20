import java.util.Arrays;
class MergeSort
{
	public static int[] sort(int[] a)
	{
		if(a.length==1)
			return a;
		int[] left = Arrays.copyOfRange(a,0,a.length/2);
		System.out.print("left:\t");
		for(int i:left)
			System.out.print(i+"\t");
		System.out.println();
		int[] right = Arrays.copyOfRange(a,a.length/2, a.length);
		System.out.print("right:\t");
		for(int i:right)
			System.out.print(i+"\t");
		System.out.println();
		sort(left);
		sort(right);
		merge(left,right,a);
		return a;
	}

	public static void merge(int[] left, int[] right, int[] a)
	{
		int leftIndex = left.length-1;
		int rightIndex = right.length-1;
		int k = left.length + right.length -1;
		while(leftIndex>=0 && rightIndex>=0)
		{
			if(left[leftIndex]>right[rightIndex])
			{
				a[k] = left[leftIndex];
				leftIndex--;
			}
			else
			{
				a[k] = right[rightIndex];
				rightIndex--;
			}
			k--;
		}
		if(leftIndex>=0)
		{
			while(leftIndex>=0)
			{
				a[k] = left[leftIndex];
				k--;
				leftIndex--;
			}
		}
		else if(rightIndex>=0)
		{
			while(rightIndex>=0)
			{
				a[k] = right[rightIndex];
				k--;
				rightIndex--;
			}
		}
		System.out.print("sort:\t");
		for(int i:a)
			System.out.print(i+"\t");
		System.out.println();
	}

	public static void main(String arg[])
	{
		int a[] = {10, 30, 20, 70, 50, 40, 90};
		// int[] b = Arrays.copyOfRange(a, 1,4);
		// for(int j:b)
		// {
			// System.out.println(j);
		// }
		sort(a);
		// for(int i:a)
		// {
			// System.out.println(i);
		// }
	}
}
