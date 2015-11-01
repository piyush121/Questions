public class SameTree
{
	public boolean isSameTree(TreeNode p, TreeNode q)
	{
		TreeNode pNode = p;
		TreeNode qNode = q;
		if(pNode==null && qNode==null)
			return true;
		if(pNode!=null && qNode!=null)
		{
			if(pNode.val != qNode.val)
				return false;
			return  isSameTree(pNode.left, qNode.left) && isSameTree(pNode.right, qNode.right);
		}
		return false;
    }
}
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
	{
		val = x;
		left = null;
		right = null;
	}
}
