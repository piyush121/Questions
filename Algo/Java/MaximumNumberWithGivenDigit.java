class MaximumNumberWithGivenDigit
{
	{{{
	public long findMaxNumber(long n)
	{
		long result=0;
		int[] a = new int[10];
		while(n!=0)
		{
			int temp = (int)n%10;
			a[temp]++;
			n = n/10;
		}
		for(int i=a.length-1;i>=0;i--)
		{
			if(a[i]==0)
				continue;
			else
				for(int j=0;j<a[i];j++)
					result = result*10+i;
		}
		return result;
	}
	}}}
	public static void main(String args[])
	{
		MaximumNumberWithGivenDigit m = new MaximumNumberWithGivenDigit();
		System.out.println(m.findMaxNumber(89834553));
	}
}
