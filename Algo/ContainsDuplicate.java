/* https://leetcode.com/problems/contains-duplicate/ */
import java.util.HashSet;

public class ContainsDuplicate
{
    public static void main(String args[])
    {

    }

    public boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!set.contains(nums[i]))
            {
                set.add(nums[i]);
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
