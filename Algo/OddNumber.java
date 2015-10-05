class OddNumber //using Bit manipulation
{
	public boolean isOdd(int num)
	{
		if((num&1)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String args[])
	{
		OddNumber o = new OddNumber();
		System.out.println(o.isOdd(90));
	}
}
