public class MaxDepth
{
	public int maxDepth(TreeNode root)
	{
		TreeNode node = root;
        return  helper(node, 0,0,0)-1;
    }

	public int helper(TreeNode node ,int leftDepth, int rightDepth ,int depth)
	{
		if(node == null)
		{
			return 0;
		}
		leftDepth = helper(node.left, leftDepth, rightDepth, depth);
		rightDepth = helper(node.right, leftDepth, rightDepth, depth);
		System.out.println("left: "+leftDepth+" right: "+rightDepth+" depth: "+depth+" node: "+ node.val);
		return Math.max(leftDepth, rightDepth)+1;
	}

	public static void main(String args[])
	{
		MaxDepth md = new MaxDepth();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(9);
		root.left.right.right = new TreeNode(10);
		root.left.right.right.left = new TreeNode(13);
		root.left.right.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(11);
		root.right.right.right = new TreeNode(12);
		root.right.right.left.right = new TreeNode(15);
		root.right.right.right.right = new TreeNode(16);
		System.out.println(md.maxDepth(root));
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
