class Subset
{
	public static void printSubset(char[] a)
	{
		int currentSubset = (int)Math.pow(2, a.length) -1;
		while(currentSubset!=-1)
		{
			int temp = currentSubset;
			System.out.print("{");
			for(int i=0;i<a.length;i++)
			{
				if((temp & 1)==1)
				{
					System.out.print(a[i]);
				}
				temp >>= 1;
			}
			System.out.print("}\n");
			currentSubset--;
		}
	}
	
	public static void main(String args[])
	{
		char[] a = {'a','b','c', 'd'};
		Subset.printSubset(a);
	}
}