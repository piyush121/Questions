public class CloneBinaryTree
{
	public TreeNode clone(TreeNode root)
	{
		if(root==null)
			return null;
		TreeNode clonedRoot = new TreeNode(root.val);
		clonedRoot.left = clone(root.left);
		clonedRoot.right = clone(root.right);
		return clonedRoot;
	}
	
	public static void main(String args[])
	{
		CloneBinaryTree c = new CloneBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		TreeNode clonedRoot = c.clone(root);
		System.out.println(clonedRoot.val);
		System.out.println(clonedRoot.left.val);
		System.out.println(clonedRoot.right.val);
	}
}
class TreeNode
{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int val)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
