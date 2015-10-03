/* http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/ */

public class BoundaryTraversalOfBinaryTree
{
	private void printLeafNodes(TreeNode node)
	{
		if(node!=null)
		{
			printLeafNodes(node.left);
			if(node.left==null && node.right==null)
			{
				System.out.print(node.value+" ");
			}
			printLeafNodes(node.right);
		}
	}

	private void printLeftNodes(TreeNode node)
	{
		if(node!=null)
		{
			if(node.left!=null)
			{
				System.out.print(node.value+" ");
				printLeftNodes(node.left);
			}
			else if(node.right!=null)
			{
				System.out.print(node.value+" ");
				printLeftNodes(node.right);
			}
		}
		return;
	}

	private void printRightNodes(TreeNode node)
	{
		if(node!=null)
		{
			if(node.right!=null)
			{
				printRightNodes(node.right);
				System.out.print(node.value+" ");
			}
			else if(node.left!=null)
			{
				printRightNodes(node.left);
				System.out.print(node.value+" ");
			}
		}
		return;
	}

	public static void main(String args[])
	{
		BoundaryTraversalOfBinaryTree bt = new BoundaryTraversalOfBinaryTree();
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		root.right.right = new TreeNode(25);
		System.out.print(root.value+" ");
		bt.printLeftNodes(root.left);
		bt.printLeafNodes(root.left);
		bt.printLeafNodes(root.right);
		//System.out.println();
		//System.out.println();
		bt.printRightNodes(root.right);
		System.out.println();
	}
}
