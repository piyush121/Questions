public class CompleteSubTree1
{
	int maxSize;
	int maxNode;

	public void findCompleteSubTree(TreeNode root)
	{
		int depth = 0;
		int left = 0;
		int right = 0;
		int num = helper(root,left,right,depth);
			System.out.println(num);
			
		System.out.println("printing max node and depth");
		System.out.println(maxNode);
		System.out.println(maxSize);
	}
	
	public int helper(TreeNode root, int left, int right, int depth)
	{
		int subLeft, subRight;
		TreeNode node = root;
		if(node==null)
		{
			int n = 0;
			return n;
		}
		subLeft = helper(node.left, left , 0, depth);
		subRight = helper(node.right, 0, right, depth);
		System.out.println("left: "+subLeft+" right: "+subRight+" depthMax: "+maxSize+" maxNode: "+maxNode+" node: "+ node.val);	
		
		if(subLeft == subRight)
		{
			System.out.println("equal");
			depth = subLeft + 1;
			if(depth > maxSize)
			{
				maxSize = depth;
				maxNode = node.val;
			}
		}
		else
		{
			System.out.println("not equal");
			depth = Math.min(subLeft, subRight)+1;
			if(depth > maxSize)
			{
				maxSize = depth;
				maxNode = node.val;
			}
		}
		return depth;
	}
	
	public static void main(String args[])
	{
		CompleteSubTree1 cs = new CompleteSubTree1();
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