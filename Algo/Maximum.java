class Maximum
{
	static int[] a = {1,3,6,2,9,8,5,7,4};

	public static void main(String args[])
	{
		for(int i=0;i<a.length;i++)
		{
			int max = Integer.MIN_VALUE;
			for(int j=0;j<i;j++)
			{
				if(a[j]>max)
				{
					max = a[j];
				}
			}
			System.out.println(max);
		}
	}
}
