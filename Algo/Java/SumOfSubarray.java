/*
http://www.careercup.com/question?id=5707919444148224

Given a 1D array, implement function Sum(x1,x2) where x1 and x2 are indices of array. 
Find sum of all elements in between the given indices inclusive of them. 
Do in Time complexity of O(1).
*/

class SumOfSubarray
{
	//idea is to preprocess the array and store the sum of all the items 
	//from index 0 to index i at index i
	private int[] s;

	public void preprocess(int[] nums)
	{
		int sum = 0;
		for(int i=0;i<nums.length;i++)
		{
			sum += nums[i];
			s[i+1] = sum;
		}

		for(int k:s)
			System.out.print(k+" ");
		System.out.println();
	}

	public int sum(int x1, int x2)
	{
		//System.out.println(s[x1]);
		//System.out.println(s[x2+1]);
		return s[x2+1] - s[x1];
	}

	public static void main(String args[])
	{
		int[] nums = {1, 2, 3, 4, 5, 6}; //0 1 3 6 10 15 21
		SumOfSubarray ss = new SumOfSubarray();
		ss.s = new int[nums.length+1];
		ss.preprocess(nums);
		System.out.println(ss.sum(0, 3));
		System.out.println(ss.sum(2, 5));
	}	
}