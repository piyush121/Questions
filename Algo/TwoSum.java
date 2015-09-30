import java.util.*;
class TwoSum
{
	HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
	public static void main(String args[])
	{
		int[] result = new int[2];
		int[] arr = {11, 5, 2, 7};
		int target = 9;
		TwoSum ts = new TwoSum();
		ts.findTwoSum(arr, target, result);
	}
	
	public void findTwoSum(int[] arr, int target, int[] result)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(hashMap.containsKey(arr[i]))
			{
				result[0] = hashMap.get(arr[i])+1;
				result[1] = i+1;
			} 
			else
			{
				hashMap.put(target-arr[i], i);
			}
		}
		System.out.println(result[0]+" "+result[1]);
	}
}