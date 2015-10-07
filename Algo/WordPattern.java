/* https://leetcode.com/problems/word-pattern/ */
import java.util.HashMap;
class WordPattern
{
	public static void main(String args[])
    {
    	 String pattern = "abba"; String str = "dog cat cat dog";
		// String pattern = "abba"; String str = "dog cat cat fish";
  		// String pattern = "aaaa"; String str = "dog cat cat dog";
		 // String pattern = "abba"; String str = "dog dog dog dog";
		WordPattern w = new WordPattern();
		System.out.println(w.wordPattern(pattern, str));
    }

	public boolean wordPattern(String pattern, String str) 
	{
		if(str==null || pattern==null)
			false;
        String[] words = str.split("\\s");
        if(pattern.length()!=words.length)
        	return false;
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for(int i=0;i<pattern.length();i++)
        {
        	System.out.println("i:"+i);
        	if(map1.containsKey(pattern.charAt(i)))
        	{
        		if(!words[i].equals(map1.get(pattern.charAt(i))))
        			return false;
        	}
        	else
        	{
        		map1.put(pattern.charAt(i), words[i]);
        		if(!map2.containsKey(words[i]))
        		{
        			map2.put(words[i], pattern.charAt(i));
        		}
        		else
   					return false;
        	}
        }
        return true;
    }
}