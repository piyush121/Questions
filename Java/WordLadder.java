import java.util.*;
class WordLadder
{

	public static void main(String args[])
	{
		WordLadder wl = new WordLadder();
		HashSet<String> dict = new HashSet<String>();
		String[] a = {"hot", "dot", "dog", "lot", "log"};
		String start = "hit";
		String end = "cog";
		for(String s:a)
		{
			dict.add(s);
		}
		dict.add(end);
		System.out.println(wl.check(start, end, dict));
	}
	
	public int check(String start, String end, HashSet<String> dict)
	{
		ArrayDeque<String> wordQueue = new ArrayDeque<String>();
		ArrayDeque<Integer> distanceQueue = new ArrayDeque<Integer>();
		if(dict.size()==0)
		{
			return 0;
		}
		String currentWord = start;
		int currentDistance = 1;
		wordQueue.add(start);
		distanceQueue.add(currentDistance);
		while(!wordQueue.isEmpty())
		{
			currentWord = wordQueue.poll();
			currentDistance = distanceQueue.poll();
			if(currentWord.equals(end))
			{
				return currentDistance;
			}
			for(int i=0;i<currentWord.length();i++)
			{
				char[] arr = currentWord.toCharArray();
				for(char c = 'a';c<='z';c++)
				{
					if(c==arr[i])
					{
						continue;
					}
				
					arr[i] = c;
					String temp = new String(arr);
					
					if(dict.contains(temp))
					{
						wordQueue.add(temp);
						distanceQueue.add(currentDistance + 1);
						dict.remove(temp);
					}
				}
			}
		}
		return 0;
	}
}