class ReverseInteger
{
	public int reverse(int x)
    {
        long result = 0;
		int m = 0;
		while(x!=0)
		{
			m = x%10;
			result = result*10 + m;
			x = x/10;
		}
		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE)
			return 0;
		return (int)result;
    }

	public static void main(String args[])
	{
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(-321));
	}
}
