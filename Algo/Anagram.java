import java.util.*;
class Anagram
{
	public boolean isAnagram(String left, String right)
	{
		if(left==null || right==null)
			return false;
		if(left.length() != right.length())
			return false;
		HashMap<Character, Integer> occurrenceMap = new HashMap<Character, Integer>();
		for(char c ='a'; c<='z';c++)
		{
			occurrenceMap.put(c, 0);
		}

		for(int i=0;i<left.length();i++)
		{
			int ol = occurrenceMap.get(left.charAt(i));
			occurrenceMap.put(left.charAt(i),ol++);
			int or = occurrenceMap.get(right.charAt(i));
			occurrenceMap.put(right.charAt(i),or--);
		}

		for(Integer value : occurrenceMap.values())
		{
			if(value!=0)
				return false;
		}
		return true;
	}

	public static void main(String args[])
	{
		Anagram a = new Anagram();
		System.out.println(a.isAnagram("cat", "act"));
		System.out.println("cat".hashCode());
		System.out.println("act".hashCode());
	}
}
