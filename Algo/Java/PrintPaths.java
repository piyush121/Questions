public class PrintPaths
{
	public void printPaths(TreeNode root)
	{
		helper(root, "");
	}

	public void helper(TreeNode root, String path)
	{
		if(root==null)
			return;
		path = path+root.val;
		if(root.left==null && root.right==null)
		{
			System.out.println(path);
		}
		else
		{
			helper(root.left, path);
			helper(root.right, path);
		}
	}

	public static void main(String args[])
	{
		PrintPaths p = new PrintPaths();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		p.printPaths(root);
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
