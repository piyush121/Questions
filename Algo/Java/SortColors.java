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
    //take two pointer indexes
    //@p0: keep track of zeros (at the start of the array)
    //@p2: keep track of twos (at the end of the array)
    public void sortColors(int[] nums)
    {
       int[] temp = new int[nums.length];
       //initialize p0 to 0 position
       //initialize p2 to end position in an array
       int p0 = 0;
       int p2 = nums.length-1;
       for(int i=0;i<nums.length;i++)
       {
          // if the number at index i is 0
          // then store 0 at index p0 in temp array
          // and increment the p0 
          if(nums[i]==0)
          {
              temp[p0] = 0;
              p0++;
          }
          // else if the number at index i is 2
          // then store 2 at index p2 in temp array
          // and decrement the index p2 by 1
          else if(nums[i]==2)
          {
              temp[p2] = 2;
              p2--;
          }
       }
       //if p0 is less than p2 
       // then there is gap in between the two indexes 
       // which should be filled with 1
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
