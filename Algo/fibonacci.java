class fibonacci
{
	int fib1 = 1;
	int fib2 = 0;
	public static void main(String args[])
	{
		fibonacci f = new fibonacci();
		for(int i=0;i<10;i++)
			System.out.print(f.fib(i)+" ");
		for(int i=0;i<10;i++)
			System.out.print(f.fibRecursion(i)+" ");
	}

	public int fib(int n)
	{
		if( n==0)
		{
			return fib2;
		}
		if(n==1)
		{
			return fib1;
		}
		else
		{
			int fibn = fib2 + fib1;
			fib2 = fib1;
			fib1 = fibn;
			return fibn;
		}
	}

	public int fibRecursion(int num)
	{
		if(num==0)
			return 0;
		else if(num==1)
			return 1;
		else
			return fibRecursion(num-2) + fibRecursion(num-1);
	}
}
