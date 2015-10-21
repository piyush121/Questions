import java.util.HashSet;
import java.util.Set;
class FindWordBreak
{
	public boolean findWordBreak(String s, Set<String> dict)
	{
		Hashset<String> matchecSet = new HashSet<String>();
		if(dict.size()==0 || s.length()==0)
			return false;
		String p = s;
		String temp = "";
		int i =0;
		while(p.length()!=0 && i<=p.length()-1)
		{
			temp = temp + p.charAt(i);
			//System.out.println("i: "+i+" temp: "+temp);
			if(dict.contains(temp))
			{
				//System.out.println("if: "+temp);
				dict.remove(temp);
				matched.add(temp);
				temp = "";
				p = p.substring(i+1);
				i=0;
			}
			else if(matched.contains(temp) && )
			{
				temp ="";
				p = p.sunstring(i+1);
				i=0;
			}
			else
			{
				i++;
			}
		}
		if(p.length()==0)
			return true;
		else
			return false;
	}

	public static void main(String args[])
	{
		HashSet<String> dict = new HashSet<String>();
		dict.add("b");
		//dict.add("leet");
		//dict.add("code");
		//dict.add("payam");
		//dict.add("is");
		//dict.add("good");
		//String s1 = "leetcode";
		String s2 = "a";
		FindWordBreak fwb = new FindWordBreak();
		System.out.println(fwb.findWordBreak(s2, dict));
	}
}
