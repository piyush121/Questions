/* 
http://www.geeksforgeeks.org/check-number-fibonacci-number/

A number is Fibonacci if and only if one or both of (5*n^2 + 4) or (5*n^2 – 4) is a perfect square

*/

class CheckIfFibonacci
{
	public boolean isFibonacci(int num)
	{
		return this.isPerfectSquare((5 * num * num )+4) || this.isPerfectSquare((5 * num * num)-4);
	}

	public boolean isPerfectSquare(int n)
	{
		int s = (int)Math.sqrt(n);
		return s*s==n;
	}

	public static void main(String args[])
	{
		CheckIfFibonacci c = new CheckIfFibonacci();
		for(int i=0;i<10;i++)
			System.out.println(i+": "+ c.isFibonacci(i));
	}
}