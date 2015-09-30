class SquareRoot
{
	public static double findSquareRoot(double num)
	{
		double lo = 0;
		double hi = num;
		double mid = (hi - lo)/2;
		while(Math.abs(mid*mid - num) > 0.000000000001)
		{
			if(mid*mid > num)
			{
				hi = mid;
				mid = lo +(hi - lo)/2;
			}
			else
			{
				lo = mid;
				mid = mid + (hi-lo)/2;
			}
		}
		return mid;
	}
	
	public static void main(String args[])
	{
		System.out.println(SquareRoot.findSquareRoot(5));
	}
}