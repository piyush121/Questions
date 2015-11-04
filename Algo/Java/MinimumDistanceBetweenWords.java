/* 
http://www.careercup.com/question?id=6273553081040896
 
Q: Given a string and two words which are present in the string, 
find the minimum distance between the words 
Eg: 

"the brown qucik frog quick the", "the" "quick" O/P -> 1 
"the quick the brown quick brown the frog", "the" "the" O/P -> 2
*/
import java.util.ArrayList;
class MinimumDistanceBetweenWords
{
	public void findMinmumDistance(String text, String wordA, String wordB)
	{
		ArrayList<Integer> posA = new ArrayList<>();
		ArrayList<Integer> posB = new ArrayList<>();

		int min=Integer.MAX_VALUE;

		String a[] = text.split("\\s+");
		for(int i=0;i<a.length;i++)
		{
			if(a[i].equalsIgnoreCase(wordA))
				posA.add(i);
			if(a[i].equalsIgnoreCase(wordB))
				posB.add(i);
		}

		if(posA.size()==0 || posB.size()==0)
			System.out.println("word/words not present in the give text");
		int m = 0;
		int n = 0;
		while(m<posA.size() && n<posB.size())
		{
			//check both the list simulatneously
			//if index at posA is greater than index at posB
			//then increment index at posB to minimize the distance
			//between two indices
			if(posA.get(m) > posB.get(n))
			{
				min = Math.min(min, posA.get(m) - posB.get(n));
				n++;
			}
			else if(posA.get(m) < posB.get(n))
			{
				min = Math.min(min, posB.get(m) - posA.get(n));
				m++;
			}
			else
			{
				m++;
			}
		}
		System.out.println(min);
	}

	public static void main(String args[])
	{
		//String text = "the brown qucik frog quick the";
		String text = "the quick the brown quick brown the frog";
		String wordA = "the";
		String wordB = "the";
		MinimumDistanceBetweenWords m = new MinimumDistanceBetweenWords();
		m.findMinmumDistance(text, wordA, wordB);
	}
}