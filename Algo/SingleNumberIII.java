/* https://leetcode.com/problems/single-number-iii/ */
class SingleNumberIII
{

    public static void main(String args[])
    {

    }

    public int[] singleNumber(int[] nums)
    {
        int xor = 0;
        for (int num : nums)
        	xor ^= num;	
        xor = Integer.highestOneBit(xor);

        //dividing the nums array into two groups one with highest one bit set and other with unset

        int[] result = new int[2];
        for(int num: nums)
        {
        	if((xor & num) == 0) //highest bit is not set
        	{
        		result[0] ^= num;
        	}
        	else
        	{
        		result[1] ^= num;
        	}
        }
        return result;
    }
}
