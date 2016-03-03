class DFibonacci
{
	public int fib(int n)
	{	
		if(n<0)
			throw new IllegalArgumentException();
		if(n==0)
			return 0;
		int a=1; //Change it to 1. 
		int b =1;
		int c = -1;
		for(int i=2;i<n;i++)
		{
			c = a+b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String args[])
	{
		DFibonacci f  = new DFibonacci();
		System.out.println(f.fib(4));
	}
}
