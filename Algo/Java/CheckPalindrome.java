/* check if a given phrase (not including spaces , "" etc.) is a palindrome */
class CheckPalindrome
{
	public boolean isPalindrome(String s)
    {
    	//if the string s is null return null
        if(s==null)
			return false;
		//if the length of string s is 1 
		//then return true
		if(s.length()==1)
			return true;
		//take two pointers lo and hi 
		//where lo points to the first letter in the string s
		//and hi points to the last letter of the string
		int lo = 0;
		int hi = s.length()-1;
		//map of valid characters
		String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while(lo<hi)
		{
			//if the map doesn't contain the character @lo 
			//then skip the character
			if(!map.contains(s.charAt(lo)+""))
				lo++;
			//if the map doesn't contain the character @hi
			//skip the character
			else if(!map.contains(s.charAt(hi)+""))
				hi--;
			//if map contains both the characters @hi and @lo
			else if(map.contains(s.charAt(lo)+"") && map.contains(s.charAt(hi)+""))
			{
				String l = s.charAt(lo)+"";
				String h = s.charAt(hi)+"";
				//if the character @hi equals character @lo
				//then increment the index lo
				//decremenet the index hi
				if(l.equalsIgnoreCase(h))
				{
					lo++;
					hi--;
				}
				//if the character @hi is not equal to character @lo
				//return false
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
