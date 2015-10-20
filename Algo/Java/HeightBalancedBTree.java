class HeightBalancedBTree
{
	private boolean result = true;
	public boolean isBalanced(TreeNode root)
	{
		helper(root);
		return result;
    }

	public int helper(TreeNode root)
	{
		TreeNode node = root;
		if(node==null)
		{
			return 0;
		}
		int left = helper(node.left);
		int right = helper(node.right);
		if(Math.abs(left - right)>1)
			result = false;
		return Math.max(left,right)+1;
	}
}
