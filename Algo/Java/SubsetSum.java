/* http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/ */
class SubsetSum
{
	public boolean isSubsetSum(int[] set, int sum)
	{
		return helper(set, sum, set.length-1);
	}

	public boolean helper(int[] set, int sum, int i)
	{
		if(sum==0)
			return true;
		if(i==0 && sum > 0)
			return false;
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