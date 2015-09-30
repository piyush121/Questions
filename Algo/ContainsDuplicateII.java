/* https://leetcode.com/problems/contains-duplicate-ii/ */
import java.util.HashMap;
public class ContainsDuplicateII
{
    public static void main(String args[])
    {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i], i);
            }
            else
            {
                int index = map.get(nums[i]);
                if(i-index <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }
}
