/* http://www.geeksforgeeks.org/array-rotation/ */
public class ArrayRotation
{
	public static void main(String args[])
	{
		ArrayRotation a = new ArrayRotation();
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		a.rotate(3, arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}

	public void rotate(int steps, int[] a)
	{
		int gcd = gcd(a.length, steps);
		System.out.println(gcd);
		for(int i=0;i<gcd;i++)
		{
			int k = i;
			int temp = a[k];
			while(k+steps < a.length)
			{
				a[k] = a[k+steps];
				k = k + steps;
			}
			a[k] = temp;
		}
	}

	private int gcd(int a, int b)
	{
		if(b==0)
			return a;
		else 
			return gcd(b, a%b);
	}
}