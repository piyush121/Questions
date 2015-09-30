import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
class CombinationSum
{
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	HashSet<String> set = new HashSet<String>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) 
	{
		Arrays.sort(candidates);
		ArrayList<Integer> curr = new ArrayList<Integer>();
        return helper(candidates, target, 0, "" ,curr);
    }
	
	public List<List<Integer>> helper(int[] num, int target, int sum, String s, ArrayList<Integer> curr)
	{
		if(sum==target)
		{
			//System.out.println(curr);
			if(!set.contains(s))
			{
				set.add(s);
				list.add(new ArrayList<Integer>(curr));
			}
			//System.out.println("answer: "+s);
		}
		else
		{	
			for(int i=0;i<num.length;i++)
			{
				if(sum+num[i]<=target && (curr.size()==0 || num[i]>=curr.get(curr.size()-1)))
				{
					curr.add(num[i]);
					helper(Arrays.copyOfRange(num, i+1, num.length), target, sum+num[i], s+num[i], curr);
					curr.remove(curr.size()-1);
				}
			}
		}
		return list;
	}
	
	public static void main(String args[])
	{
		int[] c = {10,1,2,7,6,1,5};
		int t = 8;
		CombinationSum p = new CombinationSum();
		p.combinationSum(c,t);
		System.out.println(p.list);
	}
}