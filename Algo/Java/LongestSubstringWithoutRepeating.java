import java.util.HashSet;
class LongestSubstringWithoutRepeating
{
	public static void main(String args[])
	{
		LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
		//String s = "a";
		//String s = "ab";
		//String s = "bb";
		//String s = "abba";
		//String s = "dvdf";
		//String s = "dvdfxyzvt";
		String s = "abcb";
		System.out.println(solution.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s)
	{
		if(s==null || s.length()==0)
			return 0;
		if(s.length()==1)
			return 1;
        int max = Integer.MIN_VALUE;
 		HashSet<Character> set = new HashSet<>();
 		int start = 0;
    	for(int i=0;i<s.length();i++)
	    {
	    	char c = s.charAt(i);
    		if(!set.contains(c))
    		{
    			set.add(c);
    		}
    		else
    		{
    			while(s.charAt(start)!=c)
    			{
    				set.remove(s.charAt(start));
    				start++;
    			}
    			start++;
    		}
    		if(max<set.size())
    			max = set.size();
    	}
    	return max;
    }
}
