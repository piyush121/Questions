/* http://www.geeksforgeeks.org/diameter-of-a-binary-tree/ */
public class BinaryTreeDiameter
{
	int max = -1;
	//determine the height of the tree
	public int height(TreeNode root)
	{
		//if the root is null 
		//then is no node in the tree or we have reached the leaf node 
		//of the tree (terminating condition in recursion)
		if(root==null)
			return 0;
		//the height of the tree is 1 plus maximum of height of the left
		//subtree and height of right subtree
		return 1 + Math.max(height(root.left), height(root.right));
	}
	//the diameter of a tree is the farthest distance between two 
	//nodes
	public int diameter(TreeNode root)
	{
		if(root==null)
			return 0;
		//get the height of the left subtree
		int leftSubTreeHeight = height(root.left);
		//get the height of the right subtree
		int rightSubTreeHeight = height(root.right);

		//get the left diameter
		int leftDiameter = diameter(root.left);
		//get the right diameter
		int rightDiamter = diameter(root.right);
		// Return max of following three
   		// 1) Diameter of left subtree
   		// 2) Diameter of right subtree
   		// 3) Height of left subtree + height of right subtree + 1
		return Math.max(leftSubTreeHeight + rightSubTreeHeight + 1
					, Math.max(leftDiameter, rightDiamter));
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
