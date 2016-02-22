/* https://leetcode.com/submissions/detail/54213669/ */
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

	public int[] twoSum(int[] numbers, int target) 
	{
		//result array 
        int[] result = new int[2];
        //@map : Key = target-number[i], value = i
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++)
        {
        	//if map doesn't contain key added target-numbers[i] as key 
        	//i as value
            if(!map.containsKey(numbers[i]))
            {
                map.put(target-numbers[i], i);
            }
            else if(map.containsKey(numbers[i]))
            {
               result[0] = map.get(numbers[i]);
               result[1] = i;
            }
        }
        return result;
    }
}
