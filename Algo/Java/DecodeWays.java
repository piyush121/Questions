/* https://leetcode.com/problems/decode-ways/ */
import java.util.ArrayList;
import java.util.List;
class DecodeWays
{
	public int numDecodings(String s) 
	{
		if(s==null || s.equals(""))
			return 0;
        List<ArrayList<String>> list = new ArrayList<>();
        helper(s, list, new ArrayList<String>());
        return list.size();
    }

    public void helper(String s, List<ArrayList<String>> list, ArrayList<String> a)
    {
 		if(s.length()==0)
 		{
 			System.out.println(a);
 			list.add(new ArrayList<String>(a));
 			a = new ArrayList<>();
 			return;
 		}
 		if(s.length()>0)
 		{
 			a.add(s.substring(0, 1));
 			helper(s.substring(1), list, a);
 		}
    	if(s.length()>=2)
    	{
    		String temp = s.substring(0, 2);
    		if(Integer.parseInt(temp)<27)
    		{
    			a.add(temp);
    			helper(s.substring(2), list, a);
    		}
    	}
    }

    public static void main(String args[])
    {
    	DecodeWays d = new DecodeWays();
    	System.out.println(d.numDecodings("6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
    }

}