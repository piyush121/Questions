public class CompleteSubTree
{
	int maxNode;
	int maxSize;

	public void findCompleteSubTree(TreeNode root)
	{

		helper(root, -1);
		System.out.println("Depth: "+maxSize+" maxNode: "+ maxNode);
	}

	public int helper(TreeNode root, int depth)
	{
		TreeNode node = root;
		if(node==null)
		{
			depth = -1;
			return depth;
		}
		int left = helper(node.left, depth);
		int right = helper(node.right, depth);
		System.out.println("left: "+left+" right: "+right+" depthMax: "+depth+" maxNode: "+maxNode+" node: "+node.val);
		if(left==right)
		{
			System.out.println("equal");
			depth = left+1;
			if(maxSize<=depth)
			{
				maxSize = depth;
				maxNode = node.val;
			}
		}
		else
		{
			System.out.println("not equal");
			depth = Math.min(left, right)+1;
		}
		//System.out.println("depthReturn: "+depth);
		return depth;
	}

	public static void main(String args[])
	{
		CompleteSubTree cs = new CompleteSubTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(9);
		root.left.right.left.left = new TreeNode(17);
		root.left.right.left.right = new TreeNode(18);
		root.left.right.right = new TreeNode(10);
		root.left.right.right.left = new TreeNode(13);
		root.left.right.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(11);
		root.right.right.right = new TreeNode(12);
		root.right.right.left.right = new TreeNode(15);
		root.right.right.right.right = new TreeNode(16);


		cs.findCompleteSubTree(root);
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
