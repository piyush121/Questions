class FindSum
{
	public static void main(String args[])
	{
		int[] a = {-1, 100,0, 98,1};
		System.out.print(findIndex(a));
	}

	public static int findIndex(int[] a)
	{
		int sum = 0;
		for(int i=0;i<a.length;i++)
			sum = sum + a[i];
		System.out.println(sum);
		int leftSum = a[0];
		int rightSum = sum - a[0]-a[1];
		int i =1;
		while(i<a.length-1)
		{
			System.out.println("left: "+leftSum);
			System.out.println("right: "+rightSum);
			if(leftSum == rightSum)
				return i;
			else
			{
				leftSum = leftSum + a[i];
				rightSum = rightSum -a[i+1];
				i++;
			}
		}
		return -1;
	}
}
