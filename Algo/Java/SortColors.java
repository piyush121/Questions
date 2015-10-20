/*https://leetcode.com/problems/sort-colors/*/
public class SortColors
{
    public static void main(String args[])
    {
        SortColors s = new SortColors();
        //int[] nums = {0,1,2,1,0,1,2,1,0};
        int[] nums = {1,0};
        s.sortColors(nums);
    }

    public void sortColors(int[] nums)
    {
       int[] temp = new int[nums.length];
       int p0 = 0;
       int p2 = nums.length-1;
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]==0)
           {
               temp[p0] = 0;
               p0++;
           }
           else if(nums[i]==2)
           {
               temp[p2] = 2;
               p2--;
           }
       }
       while(p0<=p2)
       {
           temp[p0] =1;
           p0++;
       }
       nums = temp;

       for(int i=0;i<nums.length;i++)
       {
           System.out.print(nums[i] + "\t");
       }
       System.out.println();
   }
}
