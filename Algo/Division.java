class Division
{
	public int naiveDivide(int dividend, int divisor)
	{
		int quotient = 0;
		while(dividend >= divisor)
		{
			dividend -= divisor;
			quotient++;
		}
		return quotient;
	}

	public int efficientDivide(int dividend, int divisor)
	{
		int quotient = 0;
		int currQuotient = 1;
		int currDivisor = divisor;
		while(dividend>=divisor)
		{
			if(dividend>=currDivisor)
			{
				dividend -= currDivisor;
				quotient = quotient + currQuotient;
				currDivisor <<=1;
				currQuotient <<=1;
			}
			else
			{
				currDivisor >>>=1;
				currQuotient >>>=1;
			}
		}
		return quotient;
	}

	public static void main(String args[])
	{
		Division d = new Division();
		System.out.println(d.naiveDivide(1000,2));
		System.out.println(d.efficientDivide(1000,2));
	}
}
