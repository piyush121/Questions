import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class GenerateParentheses
{
	HashSet<String> set = null;
	GenerateParentheses()
	{
		set = new HashSet<String>();
	}
	public List<String> generateParenthesis(int n) 
	{
		List<String> list = new ArrayList<String>();
		if(n==0)
			return list;
		return helper(n, 0, 0, "", list);
    }
	
	public List<String> helper(int n, int left, int right, String p, List<String> list)
	{
		if(left==n && right==n)
		{
			if(!set.contains(p))
			{
				set.add(p);
				list.add(p);
			}
		}
		if(left<=n)
			helper(n, left+1, right, p+"(", list);
		if(right <=n && right< left)
			helper(n, left, right+1, p+")", list);
		return list;
	}
	
	public static void main(String args[])
	{
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
	}
}