import java.util.*;
class ThreeSum
{
	public void findSum(int[] a)
	{
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				HashSet<Integer> s = new HashSet<Integer>();
				s.add(i);
				s.add(j);
				map.put((0-a[i]-a[j]), s);
			}
		}

		for(int i=0;i<a.length;i++)
		{
			if(map.containsKey(a[i]))
			{
				HashSet<Integer> s = map.get(a[i]);
				if(!s.contains(i))
					System.out.println(a[i]+","+map.get(a[i]));
			}
		}
	}

	public static void main(String[] args)
	{
		ThreeSum ts = new ThreeSum();
		int[] a = {-1 ,0 ,1 ,2 ,-1 ,-4};
		ts.findSum(a);
	}
}
