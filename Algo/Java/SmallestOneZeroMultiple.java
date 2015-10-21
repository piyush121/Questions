class SmallestOneZeroMultiple
{
	public int findMultiple(int n)
	{
		return helper(n, "10");
	}

	public int helper(int n, String p)
	{
		if(p.length()<"1111111111".length() && Integer.parseInt(p)<1111111111 && Integer.parseInt(p)%n==0)
			return Integer.parseInt(p);
		else if(p.length()<"1111111111".length() && Integer.parseInt(p)<1111111111)
			return Math.min(helper(n, p+"0"),helper(n, p+"1"));
		return Integer.MAX_VALUE;
	}

	public static void main(String args[])
	{
		SmallestOneZeroMultiple s = new SmallestOneZeroMultiple();
		System.out.println(s.findMultiple(7));
	}
}
