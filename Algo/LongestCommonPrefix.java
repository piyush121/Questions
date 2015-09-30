class LongestCommonPrefix
{
	public String longestCommonPrefix(String[] strs) 
	{
		if(strs.length==0)
			return "";
		return helper(strs, "",0);
    }
	
	public String helper(String[] strs, String prefix,int length)
	{
		String temp = "";
		if(length<=strs[0].length())
		{
			temp = strs[0].substring(0, length);
		}
		else
		{
			return prefix;
		}
		int count = 0;
		for(int i=0;i<strs.length;i++)
		{
			if(temp.length() > strs[i].length() || !temp.equals(strs[i].substring(0,temp.length())))
			{
				break;
			}
			count++;
		}
		if(count == strs.length)
		{
			prefix = temp;
			System.out.println("prefix: "+prefix);
			prefix = helper(strs, prefix, length+1);
		}
		return prefix;
	}
	
	public String efficient(String[] strs)
	{
		for(int i=0;i<=strs[0].length();i++)
		{
			for(String str:strs)
				if(str.length()==i || str.charAt(i)!=strs[0].charAt(i))
					return strs[0].substring(0,i);
		}
		return "";
	}
	
	public static void main(String[] args)
	{
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = {"","aab"};
		System.out.println(lcp.longestCommonPrefix(strs));
		System.out.println(lcp.efficient(strs));
	}
}