public class BinaryTreeDiameter
{
	int max = -1;
	public int height(TreeNode root)
	{
		if(root==null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public int diameter(TreeNode root)
	{
		if(root==null)
			return 0;
		int leftSubTreeHeight = height(root.left);
		int rightSubTreeHeight = height(root.right);
		int diameter = 1 + leftSubTreeHeight + rightSubTreeHeight;
		if(max< diameter)
		{
			max = diameter;
		}
		return max-1;
	}

	public static void main(String args[])
	{
		BinaryTreeDiameter b = new BinaryTreeDiameter();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		//root.left.left.left = new TreeNode(8);
		//root.left.left.left.left = new TreeNode(9);
		root.left.right = new TreeNode(5);
		//root.left.right.left = new TreeNode(6);
		//root.left.right.left.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(b.diameter(root));
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
		this.left = null;
		this.right = null;
	}
}
