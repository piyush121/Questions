/* https://leetcode.com/problems/remove-element/ */
class RemoveElement
{
    public int removeElement(int[] nums, int val)
    {
        int leftPtr = 0;
        int rightPtr = nums.length-1;
        while(leftPtr <= rightPtr)
        {
            while(leftPtr < nums.length && nums[leftPtr] != val )
                leftPtr++;
            while(rightPtr > -1 && nums[rightPtr] == val)
                rightPtr--;

            if(leftPtr < nums.length && rightPtr > -1 &&  leftPtr < rightPtr)
            {
                //System.out.println("before: rightPtr: "+rightPtr+" leftPtr: "+ leftPtr);
                //print(nums);
                int temp = nums[leftPtr];
                nums[leftPtr] = nums[rightPtr];
                nums[rightPtr] = temp;
                leftPtr++;
                rightPtr--;
                //System.out.println("after: rightPtr: "+rightPtr+" leftPtr: "+ leftPtr);
                print(nums);
            }
        }
        return rightPtr>-1 ? (rightPtr+1) : 0;
    }

    void print(int[] nums)
    {
        for(int i : nums)
            System.out.print(i+"\t");
        System.out.println();
    }

    public static void main(String args[])
    {
        RemoveElement re = new RemoveElement();
        int[] nums = {4};
        System.out.println(re.removeElement(nums, 4));
    }
}
