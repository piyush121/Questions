import java.util.HashSet;
class LongestCommonSubsequence
{
	HashSet<String> set = new HashSet<String>();
	int max =0;
	String sub = "";
	public void find(String s, String t)
	{
		helper(s, t, "");
		System.out.println(set);
		System.out.println(max +" "+sub);
	}

	public void helper(String s, String t, String p)
	{
		if(s.length()==0 || t.length()==0)
		{
			if(!set.contains(p))
			{
				set.add(p);
				if(p.length()>max)
				{
					max = p.length();
					sub = p;
				}
				System.out.println(p);
			}
		}
		else
		{
			if(s.length()>0 && t.length()>0)
			{
				if(s.charAt(0) == t.charAt(0))
				{
					p += s.charAt(0);
					helper(s.substring(1), t.substring(1), p);
				}
				else
				{
					helper(s, t.substring(1), p);
					helper(s.substring(1), t, p);
				}
			}
		}
	}

	public static void main(String args[])
	{
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		l.find("AGGTAB", "GXTXAYB");
	}
}
