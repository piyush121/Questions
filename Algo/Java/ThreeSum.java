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

	public List<List<Integer>> threeSum(int[] nums) 
	{
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
        	for(int j=i+1;j<nums.length;j++)
        	{
        		HashSet<Integer> set = new HashSet<Integer>();
        		set.add(i);
        		set.add(j);
        		map.put(0-nums[i]-nums[j], new ArrayList<>(set));
        	}
        }
        System.out.println("map: "+map);
       	
       	for(int i=0;i<nums.length;i++)
       	{
       		if(map.containsKey(nums[i]))
       		{
       			
       			List<Integer> a = map.remove(nums[i]);
       			if(!a.contains(i))
       			{
       				ArrayList<Integer> n = new ArrayList<>();
       				for(int k: a)
       					n.add(nums[k]);
       				n.add(nums[i]);
       				Collections.sort(n);
       				list.add(n);
       			}
       		}
       	}
        return list;
    }

	public static void main(String[] args)
	{
		ThreeSum ts = new ThreeSum();
		int[] a = {-1 ,0 ,1 ,2 ,-1 ,-4};
		//ts.findSum(a);
		System.out.println(ts.threeSum(a));
	}
}
