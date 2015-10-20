import java.util.ArrayList;
class Permute
{
	public static String insertCharAt(String word, char c, int i)
	{
		String start = word.substring(0,i);
		String end = word.substring(i);
		return start + c + end;
	}

	public static ArrayList<String> permute(String word)
	{
		ArrayList<String> permutations = new ArrayList<String>();
		if(word==null || word.length() ==0)
		{
			permutations.add(" ");
			return permutations;
		}
		char first = word.charAt(0);
		System.out.println(first);
		String remainder = word.substring(1);
		System.out.println("remainder:" + remainder);
		ArrayList<String> words = permute(remainder);
		System.out.println("words:"+words+words.size());
		for(String s:words)
		{
			System.out.println("s:"+s.length());
			for(int i=0;i<s.length();i++)
			{
				permutations.add(insertCharAt(s,first, i));
			}
		}
		return permutations;
	}

	public static void permutations(String prefix, String word)
	{
		if(word.length() == 0)
			System.out.println(prefix);
		else
		{
			for(int i=0;i<word.length();i++)
				permutations(prefix+word.charAt(i), word.substring(0,i)+word.substring(i+1));
		}
	}

	public static void main(String args[])
	{
		String word = "ABCD";
		ArrayList<String>  permutations =	permute(word);
		System.out.println(permutations);
		permutations("", "ABCD");
	}
}
