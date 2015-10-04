class StringInterleave
{
	public void interleave(String s, String s1, String s2, int length)
	{
		if(s.length() == length)
			System.out.println(s);
		if(s1.length()!=0)
			interleave(s+s1.charAt(0), s1.substring(1), s2, length);
		if(s2.length()!=0)
			interleave(s+s2.charAt(0), s1, s2.substring(1), length);
	}

	public static void main(String args[])
	{
		StringInterleave l = new StringInterleave();
		String s1 = "ABC";
		String s2 = "DEF";
		l.interleave("", s1, s2, s1.length()+s2.length());
	}
}
