/* https://leetcode.com/problems/wildcard-matching/ */

public class WildcardMatching
{
	public static void main(String args[])
	{
		WildcardMatching w = new WildcardMatching();
		//System.out.println(w.isMatch("aa","a"));
		//System.out.println(w.isMatch("aa","aa"));
		//System.out.println(w.isMatch("aaa","aa"));
		//System.out.println(w.isMatch("aa", "*"));
		//System.out.println(w.isMatch("aa", "a*"));
		//System.out.println(w.isMatch("ab", "?*"));
		//System.out.println(w.isMatch("aab", "c*a*b"));
		System.out.println(w.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
	}	

	public boolean isMatch(String string, String pattern) 
	{
		System.out.println(string+" "+pattern);
		if(pattern==null || pattern.length()==0 || string==null || string.length()==0 )
		{
			return false;
		}
    	if(pattern.equals(string) || (pattern.equals("*") && string!=null)
    		|| (pattern.equals("?") && string.length()==1))
    	{
    		return true;
    	}    

    	char[] arr = string.toCharArray();
    	char firstCharOfPattern = pattern.charAt(0);

    	if(firstCharOfPattern != '*' && firstCharOfPattern != '?')
    	{
    		if(firstCharOfPattern==arr[0])
    			return isMatch(string.substring(1), pattern.substring(1));
    		else
    			return false;
    	}
    	else if(firstCharOfPattern == '?')
    	{
    		return isMatch(string.substring(1), pattern.substring(1));
    	}
    	else if(firstCharOfPattern == '*' && pattern.length()>1)
    	{
    		char secondCharOfPattern = pattern.charAt(1);
    		int i=0;
    		while(i<arr.length && arr[i]!=secondCharOfPattern)
    		{
    			++i;
    		}
    		if(i>=arr.length)
    			return false;
    		else
    		{
    			return isMatch(string.substring(i+1), pattern.substring(2));
    		}
    	}
    	return false;
    }
}