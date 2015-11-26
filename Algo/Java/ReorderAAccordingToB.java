/*
http://www.careercup.com/question?id=5756151524229120
We have an array of objects A and an array of indexes B. Reorder objects in array A with given indexes in array B. Do not change array A's length. 
example:

var A = [C, D, E, F, G];
var B = [3, 0, 4, 1, 2];

sort(A, B);
A is now [D, F, G, C, E];
*/

class ReorderAAccordingToB
{
	
	public void reorder(char[] a, int[] b)
	{
		int count=0;
		while(count < a.length)
		{
			this.swap(a, count, b[count]);
			this.swapIndex(b, count, b[count]);
			count++;
		}

		for(char c : a)
			System.out.print(c+" ");
	}

	public void swap(char[] a, int count, int with)
	{
		char temp = a[with];
		a[with] = a[count];
		a[count] = temp;
	}

	public void swapIndex(int[] b, int count, int with)
	{
		int temp = b[with];
		b[with] = b[count];
		b[count] = temp;
	}

	public static void main(String args[])
	{
		char[] a = {'C', 'D', 'E', 'F', 'G'};
		int[] b = {3, 0, 4, 1, 2};
		ReorderAAccordingToB r = new ReorderAAccordingToB();
		r.reorder(a, b);
	}
}
