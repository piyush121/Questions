/* https://leetcode.com/problems/unique-binary-search-trees/ */
/* given number of nodes, determine the total number of unique binary search trees
 that can be created with those nodes */
class UniqueBinarySearchTrees
{
	public static void main(String args[])
	{
		UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
		System.out.println(solution.numTrees(4));
	}
	// let the root be ith node 
	// then the left sub tree will have i-1 nodes
	// and the right subtree will have n-(i-1)-1 = n-i nodes

	//dp[i] = number of unique trees that can be formed with i nodes
	public int numTrees(int n)
	{
		if(n<=0)
			return 1;
		int dp[] = new int[n+1];
		//the number of unique trees than can be formed with 0 node is 1
		dp[0] = 1;
		for(int i=1;i<=n;i++)
		{
			dp[n] = dp[n] + helper(dp, i-1) * helper(dp, n-i);
		}
		return dp[n];
    }

    int helper(int[] dp, int n)
    {
    	if(dp[n]!=0)
    		return dp[n];
    	else
    	{
    		for(int i=1;i<=n;i++)
    			dp[n] = dp[n] + helper(dp, i-1) * helper(dp, n-i);
    	}
    	return dp[n];
    }
}
