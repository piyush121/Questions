class CheckPalindrome
{
	public boolean isPalindrome(String s)
    {
        if(s==null)
			return false;
		if(s.length()==1)
			return true;
		int lo= 0;
		int hi = s.length()-1;
		String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while(lo<hi)
		{
			if(!map.contains(s.charAt(lo)+""))
				lo++;
			else if(!map.contains(s.charAt(hi)+""))
				hi--;
			else if(map.contains(s.charAt(lo)+"") && map.contains(s.charAt(hi)+""))
			{
				String l = s.charAt(lo)+"";
				String h = s.charAt(hi)+"";
				if(l.equalsIgnoreCase(h))
				{
					lo++;
					hi--;
				}
				else
				{
					return false;
				}
			}
		}
		return true;
    }

	public static void main(String args[])
	{
		CheckPalindrome v = new CheckPalindrome();
		//String c = "A man, a plan, a canal: Panama";
		String c = "race a car";
		System.out.println(v.isPalindrome(c));
	}
}
