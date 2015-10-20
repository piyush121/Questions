class IntegerMultiplication
{
	public static int multiply(int a, int b)
	{
		int sum =b;
		while(a!=1)
		{
			a = a>>1;
			b = b<<1;
			if(a%2!=0 || b%2!=0)
				sum = sum + b;
		}
		return sum;
	}

	public static void main(String arg[])
	{
		System.out.println(IntegerMultiplication.multiply(11,13));
	}
}
