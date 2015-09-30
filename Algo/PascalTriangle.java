import java.util.*;
class PascalTriangle
{
	public static void main(String args[])
	{
		System.out.println(PascalTriangle.generate(5));
	}
	
	public static List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(numRows==0)
        {
            return null;
        }
        List<Integer> n = new ArrayList<Integer>();
        n.add(1);
        l.add(n);

        for(int i=1;i<numRows;i++)
        {
            List<Integer> q = new ArrayList<Integer>(i+1);
            q.add(0,1);

            List<Integer> k = l.get(i-1);
            int j =1;
            while(j<i)
            {
                int val = k.get(j-1)+k.get(j);
                q.add(val);
                j++;
            }
			q.add(1);
            l.add(q);
        }
        return l;
    }
}