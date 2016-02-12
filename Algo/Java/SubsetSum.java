/* http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/ */
/* 
set[] = {3, 34, 4, 12, 5, 2}, sum = 11
Output:  True  //There is a subset (4, 5, 2) with sum 9.
*/
class SubsetSum
{
	public boolean isSubsetSum(int[] set, int sum)
	{
		return helper(set, sum, set.length-1);
	}
	
	// idea is to check all the subset of set recursively
	public boolean helper(int[] set, int sum, int i)
	{
		//since we subtracting any number added to the subset from the sum
		//if the sum equals to 0, we have found the subset
		//return true
		if(sum==0)
			return true;
		//i denotes the elements of the set checked so far
		//so if i==0, we have checked all the elements 
		//return false
		if(i==0 && sum > 0)
			return false;
		//if sum >= set[i] then 
		// 1. we can include the set[i] in the subset or 
		// 2. we can exclude the set[i] in the subset
		if(sum>=set[i])
			return helper(set, sum-set[i], i-1) || helper(set, sum, i-1);
		return helper(set, sum, i-1);
	}

	public static void main(String args[])
	{
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;

		SubsetSum s = new SubsetSum();
		System.out.println(s.isSubsetSum(set, sum));
	}
}