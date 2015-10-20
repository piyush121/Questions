class Exponentiation
{
	public static double power(double m, int n)
	{
		if(m==0 && n==0)
			return Double.MIN_VALUE;
		else if(m==0)
			return 0;
		else if(n==0)
			return 1;
		else if(n<0)
			return power(1/m, -n);
		if(n%2==0)
			return power(m*m, n/2);
		if(n%2 == 1)
			return m*power(m*m, (n-1)/2);
		return -1;
	}

	public static void main(String args[])
	{
		System.out.println(power(2.01,3));
	}
}
