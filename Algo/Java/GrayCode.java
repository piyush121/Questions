/* https://leetcode.com/problems/gray-code/ */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class GrayCode
{
	public static void main(String args[])
	{
		GrayCode gc = new GrayCode();
		gc.grayCodeEfficient(10);
		
	}

	public List<Integer> grayCodeEfficient(int n)
	{
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<(int)Math.pow(2, n);i++)
		{
			list.add((i >> 1) ^ i);
		}
		System.out.println(list);
		return list;
	}

	// ---- Not Efficient ----
	public List<Integer> grayCode(int n) 
	{
        boolean[] added = new boolean[(int)Math.pow(2, n)];
        Arrays.fill(added, false);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        added[0] = true;
        helper(list, added);
        System.out.println(list);
        return list;
    }

    public boolean helper(List<Integer> list, boolean[] added)
    {
    	boolean check = true;
    	for(int i=0;i<added.length;i++)
    	{
    		check = check & added[i];
    	}
    	if(check)
    		return true;
    	for(int i=1;i<added.length;i++)
    	{
    		if(isSafe(i, list, added))
    		{
    			added[i] = true;
    			list.add(i);
    			if(helper(list, added))
    				return true;
    			added[i] = false;
    			list.remove(list.size()-1);
    		} 
    	}
    	return false;
    }

    public boolean isSafe(int numToBeAdded, List<Integer> list, boolean[] added)
    {
    	if(added[numToBeAdded]==true)
    		return false;
    	int a = list.get(list.size()-1);
    	int b = numToBeAdded ^ a;
    	int count = 0;
    	while(b!=0)
    	{
    		count = count + (b&1);
    		b = b>>>1;
    	}
    	if(count!=1)
    		return false;
    	return true;
    }
    
}