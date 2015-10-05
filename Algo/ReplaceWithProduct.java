class ReplaceWithProduct
{
	public int[] replace(int[] a)
	{
		long p = 1;
		int zeroCount=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=0)
				p*=a[i];
			else
				zeroCount++;
		}

		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=0 && zeroCount==0)
			{
				a[i] = (int) p/a[i];
			}
			else if(a[i]!=0 && zeroCount!=0)
			{
				a[i] = 0;
			}
			else if(a[i]==0)
			{
				a[i] = (int)p;
			}
		}
		return a;
	}
	public static void main(String args[])
	{
		ReplaceWithProduct r = new ReplaceWithProduct();
		int[] a = {1, 2, 3, 0};
		int[] b = r.replace(a);
		for(int num:b)
			System.out.print(num+" ");
	}
}
