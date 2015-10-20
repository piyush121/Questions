import java.util.ArrayList;
class SetOperations
{
	public void union(int[] a, int[] b)
	{
		int m = 0;
		int n =	0;
		ArrayList<Integer> union = new ArrayList<Integer>();

		while(m<a.length && n<b.length)
		{
			if(a[m]<b[n])
			{
				union.add(a[m]);
				m++;
			}
			else if(b[n]<a[m])
			{
				union.add(b[n]);
				n++;
			}
			else if(a[m]==b[n])
			{
				union.add(a[m]);
				m++;
				n++;
			}
		}
		while(m<a.length)
		{
			union.add(a[m]);
			m++;
		}
		while(n<b.length)
		{
			union.add(b[n]);
			n++;
		}
		System.out.println(union);
	}

	public void intersection(int[] a, int[] b)
	{
		int m = 0;
		int n = 0;
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		while(m <a.length&& n<b.length)
		{
			if(a[m]<b[n])
				m++;
			else if(b[n]<a[m])
				n++;
			else
			{
				intersection.add(a[m]);
				m++;
				n++;
			}
		}
		System.out.println(intersection);
	}

	public static void main(String args[])
	{
		int arr1[] = {1, 2, 4, 5, 6};
		int arr2[] = {2, 3, 5, 7};
		SetOperations s = new SetOperations();
		s.union(arr1, arr2);
		s.intersection(arr1, arr2);
	}
}
