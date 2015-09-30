import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
public class ListPermutation
{
	List<List<Integer>> a = new ArrayList<List<Integer>>();
	HashSet<List<Integer>> set = new HashSet<List<Integer>>();
	public List<List<Integer>> permute(int[] num) 
	{	
		if(num==null)
			return a;
		return helper()
    }
	
	public List<List<Integer>> helper(int[] num,  ArrayList<Integer> b, int[] c);
	{
		if(b.size()==num.length)
		{
			if(!set.contains(b))
			{
				set.add(b);
				a.add(b);
			}
			for(int i=0;i<num.length;i++)
			{
				int[] temp = c;
				for(int j=0;j<i;j++)
					temp[j] = num[j];
				for(int j=i+1;j<num.length;j++)
					temp[j] = num[j];
				helper(num, b.add(num[i]), temp[j])
			}
		}
	}
}