/* 
a language contains string formed from the alphabet {a, b, c, x}
find a shortest substring in the given String such that it would contain atleast
one a, one b, one c
*/
import java.util.Set;
import java.util.HashSet;
public class ShortestSubstringWithConstraint
{
	private int start = -1;
	private int end = -1;
	private int minDiff = Integer.MAX_VALUE;

	public static void main(String args[])
	{
		ShortestSubstringWithConstraint s 
			= new ShortestSubstringWithConstraint();
		s.getMinimumDiff(10, 6, 8);

		String str = "xxbcxaacb";
		s.findSubstring(str);
	}


	public void findSubstring(String s)
	{
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('b');
		set.add('c');
		int posA = -1;
		int posB = -1;
		int posC = -1;
		for(int i=0;i<s.length();i++)
		{
			if(set.contains(s.charAt(i)))
			{
				switch(s.charAt(i))
				{
					case 'a': posA = i; break;
					case 'b': posB = i; break;
					case 'c': posC = i; break; 
				}
			}
			else
				continue;

			if(posA!=-1 && posB!=-1 && posC!= -1)
			{
				getMinimumDiff(posA, posB, posC);
			}
		}
		if(posA!=-1 && posB!=-1 && posC!= -1)
		{
			System.out.println(s.substring(start, end+1));
		}
		else
		{
			System.out.println("No such substring");
		}
	}

	private void getMinimumDiff(int aPos, int bPos, int cPos)
	{
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		if(aPos < bPos)
		{
			min = aPos;
			max = bPos;
		}
		else
		{
			min = bPos;
			max = aPos;
		}
		if(cPos < min)
		{
			min = cPos;
		}
		if(cPos > max)
		{
			max = cPos;
		}
		if((max - min)<minDiff)
		{
			start = min;
			end = max;
			minDiff = max - min;
		}
	}
}