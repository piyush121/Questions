/* https://leetcode.com/problems/combinations/ */
import java.util.ArrayList;
import java.util.List;

class Combinations
{
	public List<List<Integer>> combine(int n, int k) 
	{
   		List<List<Integer>> list = new ArrayList<>();
   		helper(n, k, 1, list, new ArrayList<>());
   		//System.out.println(list);
   		return list;
    }

    public void helper(int n, int k, int start, List<List<Integer>> list, List<Integer> l)
    {
    	if(l.size()==k)
    	{
    		//System.out.println(l);
    		list.add(new ArrayList<>(l));
    		//System.out.println(list);
    		return;
    	}
    	for(int i=start;i<=n;i++)
    	{
    		if(!l.contains(i))
    		{
    			l.add(i);
    			helper(n, k, i, list, l);
    			l.remove(l.size()-1);
    		}
    	}
    }

	public static void main(String args[])
	{
		Combinations c = new Combinations();
		c.combine(1, 1);
	}
}