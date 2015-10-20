public class MorrisTraversal
{
	public void morrisTraversal(TreeNode root)
	{
		TreeNode current = root;
		if(current==null)
			return;
		TreeNode pre;
		while(current!=null)
		{
			if(current.left == null)
			{
				System.out.print(current.val+" ");
				current = current.right;
			}
			else//if current.left is not null;
			{
				pre = current.left;
				while(pre.right!=null && pre.right!=current)
					pre = pre.right;
				if(pre.right==null)
				{
					pre.right = current;
					current = current.left;
				}
				else
				{
					//Restoring the tree
					pre.right = null;
					System.out.print(current.val + " ");
					current = current.right;
				}
			}
		}
	}

	public static void main(String args[])
	{
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(30);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(35);
		root.right = new TreeNode(60);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(70);

		MorrisTraversal m = new MorrisTraversal();
		m.morrisTraversal(root);
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
