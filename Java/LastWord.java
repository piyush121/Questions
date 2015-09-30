class LastWord
{
	public int lengthOfLastWord(String s) 
	{
		if(s==null || s.length()==0)
			return 0;
		String[] a = s.split("\\s");
		if(a.length==1)
			return 0;
		else
			return a[a.length-1].length();
    }
	
	public static void main(String args[])
	{
		LastWord l = new LastWord();
		String s = "Hello World";
		System.out.println(l.lengthOfLastWord(s));
	}
}