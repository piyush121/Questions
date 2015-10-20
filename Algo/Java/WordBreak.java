import java.util.*;
class WordBreak
{
	private HashSet<String> dict = new HashSet<String>();

	public static void main(String args[])
	{
		String[] words = {"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"};
		WordBreak wb = new WordBreak(words);
		System.out.println(wb.isWordBreakPossible("ilikesamsung"));
	}

	public WordBreak(String[] words)
	{
		for(int i=0;i<words.length;i++)
		{
			this.dict.add(words[i]);
		}
	}

	public boolean dictionaryContains(String word)
	{
		if(dict.contains(word))
		{
			//System.out.println("true");
			return true;
		}
		else
			return false;
	}

	public boolean isWordBreakPossible(String text)
	{
		if(text.length()==0)
		{
			return true;
		}
		for(int i=1;i<=text.length();i++)
		{
			if(dictionaryContains(text.substring(0,i)) && isWordBreakPossible(text.substring(i, text.length())))
			{
				return true;
			}
		}
		return false;
	}
}
