/* https://leetcode.com/problems/3sum/ */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    //sort the given array
    Arrays.sort(nums);
    //result list to be returned
    List<List<Integer>> list = new ArrayList<>();

    for(int i=0;i<nums.length;i++)
    {
      //if the element at index i and index i-1 are equal
      //then continue
      if(i>0 && nums[i]==nums[i-1])
        continue;
      int sum = 0-nums[i];
      int start = i+1;
      int end = nums.length-1;
      while(start<end)
      {
        //nums[start] + nums[end] == sum
        //then add the numbers in the list
        if(nums[start]+nums[end]==sum)
        {
          list.add(Arrays.asList(nums[i], nums[start], nums[end]));
          //check if nums[start] == nums[start+1] 
          //then start++ (skip duplicates)
          while(start<end && nums[start]==nums[start+1])
            start++;
          start++;
          //check if nums[end] == nums[end-1]
          //then end-- (skip duplicates)
          while(start<end && nums[end]==nums[end-1])
            end--;
          end--;
        }
        //if nums[start] + nums[end] > sum
        //then end-- (to get it close to the sum)
        else if (nums[start] + nums[end] > sum)
          end--;
        else 
          start++;
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
