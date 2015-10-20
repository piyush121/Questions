class CountingNumberOfBinaryTrees
{
	//not efficient time limit exceeded
	public int numTrees(int n)
	{
		int sum = 0;
		if(n==0 || n==1)
			return 1;
		for(int i=1;i<=n;i++)
		{
			int left = numTrees(i-1);
			int right = numTrees(n-i);
			sum += left*right;
		}
		return sum;
    }

	public static void main(String args[])
	{
		CountingNumberOfBinaryTrees c = new CountingNumberOfBinaryTrees();
		System.out.println(c.numTrees(5));
	}
}
