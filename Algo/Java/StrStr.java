//Use substring and equals method 
class StrStr
{
	public int strStr(String haystack, String needle)
	{
        if(needle.length()>haystack.length())
			return -1;
		for(int i=0;i<haystack.length()-needle.length()+1;i++)
		{
			int m=i;
			int k=0;
			while(k<needle.length())
			{
				if(haystack.charAt(m)==needle.charAt(k))
				{
					k++;
					m++;
				}
				else
					break;
			}
			if(k==needle.length())
				return i;
		}
		return -1;
    }

	public static void main(String args[])
	{
		StrStr s = new StrStr();
		System.out.println(s.strStr("pen", "en"));
	}
}
