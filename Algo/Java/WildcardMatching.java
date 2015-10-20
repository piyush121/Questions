class WildcardMatching
{
	public boolean isMatch(String s, String p)
    {
        char[] sa = s.toCharArray();
		char[] pa = p.toCharArray();
		int i=0;
		int j=0;
		while(i<s.length() && j<p.length())
		{
			System.out.println("i: "+i + "j: "+j);
			if(pa[j]=='?' || pa[j]==sa[i])
			{
				i++;
				j++;
			}
			else if(pa[j]=='*')
			{
				i++;
			}
			else if(pa[j]!=sa[i])
			{
				System.out.println("ghgh");
				return false;
			}
		}
		System.out.println("after i: "+i + "j: "+j);
		if(i>=s.length() && j<p.length())
			return false;
		else if(i<s.length() && j>=p.length())
			return false;
		else if(i>=s.length() && j>=p.length())
			return true;
		else
			return true;
    }

	public static void main(String args[])
	{
		WildcardMatching w = new WildcardMatching();
		System.out.println(w.isMatch("aa","a"));//false
		System.out.println(w.isMatch("aa","aa"));//true
		System.out.println(w.isMatch("aaa","aa"));//false
		System.out.println(w.isMatch("aa", "*"));//true
		System.out.println(w.isMatch("aa", "a*"));//true
		System.out.println(w.isMatch("ab", "?*"));//true
		System.out.println(w.isMatch("aab", "c*a*b")); //false
	}
}
