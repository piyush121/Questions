class MergeSortedArray
{
	public static void main(String args[])
	{
		MergeSortedArray mga = new MergeSortedArray();
		int[] a = new int[10];
		a[0] = 2;
		a[1] = 4;
		a[2] = 6;
		a[3] = 8;
		a[4] = 10;
		int[] b = {1,3,7, 9, 11};
		int m = 5;
		int n = 5;
		mga.merger(a,m,b,n);
	}

	public void merger(int[] a,int m, int[] b, int n)
	{
		while(m>0 && n>0)
		{
			System.out.println("m:"+m+" n:"+n);
			if(a[m-1]>b[n-1])
			{
				a[m+n-1] = a[m-1];
				m--;
			}
			else
			{
				a[m+n-1] = b[n-1];
				n--;
			}
		}
		while(n>0)
		{
			a[m+n-1] = b[n-1];
			m--;
			n--;
		}
		for(int i=0;i<a.length-1;i++)
		{
			System.out.print(a[i]);
		}
	}
}
