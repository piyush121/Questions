class DecodeWays
{
	int count = 0;
	String map = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public int numDecodings(String s)
	{
		if(s==null||s=="")
			return 0;
		return helper("", s);
    }
	//s = "123"
	public int helper(String s, String r)
	{
		if(r.equals(""))
		{
			count = count+1;
			//System.out.println(s);
		}
		if(r.length()>0)
			helper(s+map.charAt(Integer.parseInt(r.charAt(0)+"")), r.substring(1));
		if(r.length()>=2 && Integer.parseInt(r.substring(0,2))<27)
			helper(s+map.charAt(Integer.parseInt(r.substring(0,2))), r.substring(2));
		return count;
	}

	public static void main(String args[])
	{
		DecodeWays dc = new DecodeWays();
		System.out.println(dc.numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
	}


}
