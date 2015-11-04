/* https://leetcode.com/problems/subsets/ */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Subset
{
	public static void printSubset(char[] a)
	{
		int currentSubset = (int)Math.pow(2, a.length) -1;
		while(currentSubset!=-1)
		{
			int temp = currentSubset;
			System.out.print("{");
			for(int i=0;i<a.length;i++)
			{
				if((temp & 1)==1)
				{
					System.out.print(a[i]);
				}
				temp >>= 1;
			}
			System.out.print("}\n");
			currentSubset--;
		}
	}

	public List<List<Integer>> subsets(int[] nums) 
	{
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list);
        System.out.println(list);
        return list;
    }

    public List<List<Integer>> helper(int[] nums, List<List<Integer>> list)
    {
    	int currentSubset = (int)Math.pow(2, nums.length) - 1;
    	for(int i=0;i<=currentSubset;i++)
    	{
    		int temp = i;
    		List<Integer> l = new ArrayList<>();
    		for(int j=0;j<nums.length;j++)
    		{
    			if((temp & 1) == 1)
    				l.add(nums[j]);
    			temp >>>=1;
    		}
    		Collections.sort(l);
    		list.add(l);
    	}
    	return list;
    }

	public static void main(String args[])
	{
		//char[] a = {'a','b','c', 'd'};
		//Subset.printSubset(a);
		int[] nums = {1, 2, 3};
		Subset s = new Subset();
		s.subsets(nums);
	}
}
