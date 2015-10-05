class HammingWeight
{
	public int hammingWeight(int n)
	{
		if(n>Integer.MAX_VALUE)
			return 1;
		int count = 0;
		while(n!=0)
		{
			if((n&1)==1)
				count++;
			n = n>>>1;
		}
		return count;
	}

	public static void main(String args[])
	{
		HammingWeight hw = new HammingWeight();
		System.out.println(hw.hammingWeight(2147483640));
		System.out.println(Integer.MAX_VALUE);
	}
}
