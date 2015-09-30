class DFibonacci
{
	public int fib(int n)
	{
		int a=0;
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