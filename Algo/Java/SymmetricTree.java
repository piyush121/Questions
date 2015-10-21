class SymmetricTree
{
	public boolean isSymmetric(TreeNode root)
	{
		if(root==null)
			return true;
		return helper(root.left, root.right);
    }

	public boolean helper(TreeNode leftNode, TreeNode rightNode)
	{
		if(left==null && right == null)
			return true;
		if(left.val == right.val)
			return helper(leftNode.right, rightNode.left) && helper(leftNode.left, rightNode.right);
		else
			return false;
	}
}
