class CheckAnagrams
{
	public boolean isAnagram(String s, String t)
	{
		if(s.length()!=t.length())
			return false;
		int[] a = new int[256];
		int[] b = new int[256];

		for(int i=0;i<s.length();i++)
		{
			a[s.charAt(i)]++;
			b[t.charAt(i)]++;
		}

		for(int i=0;i<256;i++)
		{
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}


	public static void main(String args[])
	{
		String s = "geeksforgeeks";
		String t = "forgeeksgeeks";
		CheckAnagrams c = new CheckAnagrams();
		System.out.println(c.isAnagram(s,t));
	}
}
