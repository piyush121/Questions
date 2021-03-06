/* https://leetcode.com/problems/largest-number/ */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class LargestNumber
{
	//idea : Every number can be either appended to the existing number 
	// or it can be prefixed to create a number larger than the previous number
	public String largestNumber(int[] nums) 
	{
		 List<String> list = new ArrayList<>();
        int max = 0;
    	for(int i=0;i<nums.length;i++)
    	{
    	    if(max < nums[i])
    	        max = nums[i];
    		list.add(nums[i]+"");
    	}    

    	Comparator<String> comparator = new Comparator<String>()
    	{
    		public int compare(String s1, String s2)
    		{
    			return (s2+s1).compareTo(s1+s2);
    		}
    	};

    	Collections.sort(list, comparator);

    	StringBuilder sb = new StringBuilder();
    	for(String s : list)
    		sb.append(s);
    	//System.out.println(sb);
    	//check for test cases [0, 0] -> "0"
    	return max==0?"0":sb.toString();
    }

	public static void main(String args[])
	{
		int[] nums = {3, 34, 30, 9, 5};
		LargestNumber l = new LargestNumber();
		l.largestNumber(nums);
	}
}
