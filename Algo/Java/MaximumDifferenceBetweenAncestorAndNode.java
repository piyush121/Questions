/* http://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/?utm_source=feedburner&utm_medium=email&utm_campaign=Feed%3A+Geeksforgeeks+%28GeeksforGeeks%29 */

public class MaximumDifferenceBetweenAncestorAndNode
{
	public static void main(String args[])
	{
		MaximumDifferenceBetweenAncestorAndNode m  
			= new MaximumDifferenceBetweenAncestorAndNode();
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);

		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);

		System.out.println(m.maxDifference(root));

	}	

	public int maxDifference(TreeNode root)
	{
		return maxDifferenceHelper(root, Integer.MIN_VALUE);
	}

	public int maxDifferenceHelper(TreeNode root, int result)
	{	
		//if root is null (in case of one child)
		//then return Integer.MAX_VALUE
		if(root==null)
			return Integer.MAX_VALUE;
		//if node is the leaf node
		//then return the node value
		if(root.left == null && root.right==null)
			return root.val;
		//recursively find the minimum node in the left subtree
		// and right subtree
		int min = Math.min(maxDifferenceHelper(root.left, result),
							maxDifferenceHelper(root.right, result));

		result = Math.max(result, root.val - min);
		return Math.min(min, root.val);
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val)
	{
		this.val = val;
		this.left = null;
		this.right = null;
	}
}