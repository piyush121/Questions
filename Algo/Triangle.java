import java.util.*;
class Triangle
{
	static int[] total;
	public static void main(String args[])
	{
		Triangle triangle = new Triangle();
		ArrayList<ArrayList<Integer>> t1 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> s1 = new ArrayList<Integer>();
		s1.add(2);
		t1.add(s1);
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		s2.add(3);
		s2.add(4);
		t1.add(s2);
		ArrayList<Integer> s3 = new ArrayList<Integer>();
		s3.add(6);
		s3.add(5);
		s3.add(7);
		t1.add(s3);
		ArrayList<Integer> s4 = new ArrayList<Integer>();
		s4.add(4);
		s4.add(1);
		s4.add(8);
		s4.add(3);
		t1.add(s4);
		total = new int[t1.size()];
		int l = total.length-1;
		for(int i=0;i<t1.get(l).size();i++)
		{
			total[i] = t1.get(l).get(i);
		}
		System.out.println(triangle.maxPathSum(t1));
	}
	
	public int maxPathSum(ArrayList<ArrayList<Integer>> t)
	{
		for(int i=t.size()-2;i>=0;i--)
		{
			for(int j=0;j<t.get(i+1).size()-1;j++)
			{
				total[j] = t.get(i).get(j) + Math.min(total[j], total[j+1]);
			}
		}
		return total[0];
	}
}