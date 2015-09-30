class MinDepthBinaryTree
{
	public int minDepth(TreeNode root) 
	{
        helper(root);
    }
	
	public int helper(TreeNode root)
	{
		ListNode node = root;
		if(node==null)
		{
			return 0;
		}
		return 1+ Math.min(helper(node.left) ,helper(node.right));
	}
}