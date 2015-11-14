/* http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/ */

public class CheckIfBinarySearchTree
{
	public boolean isBinarySearchTree(TreeNode root)
	{
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean helper(TreeNode node, int min, int max)
	{
		if(node == null)
			return true;
		if(node.val < min || node.val > max)
			return false;
		return helper(node.left, min, node.val-1) && helper(node.right, node.val+1, max);
	}

	public static void main(String args[])
	{
		CheckIfBinarySearchTree c = new CheckIfBinarySearchTree();
		//TreeNode root = new TreeNode(4);
		//root.left = new TreeNode(2);
		//root.right = new TreeNode(5);
		//root.left.left = new TreeNode(1);
		//root.left.right = new TreeNode(3);
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		System.out.println(c.isBinarySearchTree(root));
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val)
	{
		this.val = val;
	}
}