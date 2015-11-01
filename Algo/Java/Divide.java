class Divide
{
	public int divide(int dividend, int divisor)
    {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        if(dividend == 0)
            return 0;
        if(dividend < divisor)
            return 0;
		if(divisor==1)
			return dividend;
        int count = 0;
		boolean dividendPolarity = dividend<0?true:false;
		boolean divisorPolarity = divisor<0?true:false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
        while(dividend >= divisor)
        {
            dividend = dividend - divisor;
			++count;
        }
		if(dividendPolarity == divisorPolarity)
			return count;
		else
			return 0-count;
    }

	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		Divide d = new Divide();
		System.out.println(d.divide(2147483647, 2));
		System.out.println((System.currentTimeMillis()-start));
	}
}
