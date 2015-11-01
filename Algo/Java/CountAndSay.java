/* https://leetcode.com/problems/count-and-say/ */

public class CountAndSay
{
	public String countAndSay(int n) 
	{
		String num = 1+"";
        for(int i=1;i<n;i++)
        {
        	num = helper(num);
        }
        return num;
    }

    public String helper(String num)
    {
    	String s="";
    	int count = 1;
    	char prevChar = num.charAt(0);
    	for(int i=1;i<num.length();i++)
    	{
    		if(num.charAt(i)==prevChar)
    		{
    			++count;
    		}
    		else
    		{
    			s += count+""+prevChar;
    			prevChar = num.charAt(i);
    			count = 1;
    		}
    	}
    	s+=count+""+prevChar;
    	return s;
    }

    public static void main(String args[])
    {
    	CountAndSay cs = new CountAndSay();
    	System.out.println(cs.countAndSay(1));
    }
}