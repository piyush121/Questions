/* 
http://www.careercup.com/question?id=5120301346062336 
Q: Find the first and last occurrence of a number in a sorted array of integers 
For Example: int[] a = {1,2,3,4,5,5,7,8}, 5
output 4, 5
*/

import java.util.Arrays;

class FirstLastIndexofNumber
{
	// idea is to do binarySearch and find position of element 
	// and from that position search towards start and end of the array
	// until different element is found
	
	public void getIndex(int[] nums, int num)
	{
		int currIndex = Arrays.binarySearch(nums, num);
		int firstIndex = currIndex;
		int lastIndex = currIndex;
		while(firstIndex>-1 && nums[firstIndex] == num)
		{
			firstIndex--;
		}
		while(lastIndex<nums.length && nums[lastIndex]==num)
		{
			lastIndex++;
		}
		System.out.println((firstIndex+1)+", "+(lastIndex-1));
	} 

	public static void main(String args[])
	{
		//int[] a = {1,2,3,4,5,5,7,8};
		int[] a = {5, 5};
		FirstLastIndexofNumber f = new FirstLastIndexofNumber();
		f.getIndex(a, 5);
	}
}