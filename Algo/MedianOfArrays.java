class MedianOfArrays
{
	
	public double getMedian(int[] a, int[] b)
	{
		
	}
	
	public double helper(int[] a, int[]b ,int n)
	{
		int m1 = -1; //median of array 1
		int m2 = -1; //median of array 2
		
		if(n<=0)
			return -1;
		if(n==1)
			return (a[0]+b[0])/2;
		if(n==2)
			return (Math.max(a[0], b[0]) + Math.min(a[1], b[1]))/2;
			
		m1 = median(a, n);
		m2 = median(b, n);
		
		if(m1==m2)
			return m1;
		//if m1 < m2 then median must exist in a[m1....] and b [....m2]
		 if(m1<m2)
		{
			if(n%2 == 0)
				return helper(Arrays.copyOfRange(a, ))
		}
		
	}
	
	public double median(int[] a, int n)
	{
		if(a.length%2==0)
		{
			return (a[a.length/2] + a[(a.length/2)-1])/2;
		}
		else
		{
			return a[a.length/2];
		}
	}
}