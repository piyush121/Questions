/* 
7 8 2 1 6 4
1 2 8 7 6 4
4 6 7 8 2 1
8 7 6 4 2 1
*/

class PancakeSort
{
	static int[] a = {7,8,2,1,6,4};
	public static void reverse(int startIndex, int endIndex)
	{
		int s = startIndex;
		int e = endIndex;

		while(s<e)
		{
			int temp = a[s];
			a[s] = a[e];
			a[e] = temp;
			s++;
			e--;
		}
	}

	public static void pancakeSort()
	{
		for(int i = a.length-1;i>=0;i--)
		{
			int index = findMaxIndex(0, i);
			if(index ==0)
				reverse(0,i);
			else
			{
				reverse(0,index);
				reverse(0,i);
			}
			printArray();
		}
	}

	public static int findMaxIndex(int startIndex, int endIndex)
	{
		int max = Integer.MIN_VALUE;
		int index = -1;
		for(int i=startIndex;i<=endIndex;i++)
		{
			if(a[i]>max)
			{
				max = a[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String args[])
	{
		pancakeSort();
	}

	public static void printArray()
	{
		for(int num: a)
		{
			System.out.print(num+"\t");
		}
		System.out.println();
	}
}
