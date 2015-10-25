class Power
{
	public double pow(double x, int n)
    {
		if(n<0)
			return pow(1/x, n);
        if(n==1)
            return x;
        if(n%2==0)
            return pow(x*x, n/2);
        else
        {
            return x*pow(x, n-1);
        }
	}

	public static void main(String args[])
	{
		Power p = new Power();
		System.out.println(p.pow(2.0,3));
		System.out.println(1.0==1.00000);
		System.out.println(1.0==1/1.0000);
	}
}
