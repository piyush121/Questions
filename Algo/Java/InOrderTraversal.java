/* http://www.geeksforgeeks.org/618/ */
import java.util.List;
import java.util.ArrayList;
public class InOrderTraversal
{
	public List<Integer> inorderTraversal(TreeNode root)
	{
		TreeNode node = root;
		ArrayList<Integer> l = new ArrayList<Integer>();
		return helper(node, l);
    }

	public List<Integer> helper(TreeNode node, List<Integer> l)
	{
		//check if the tree node is null
		//return the list
		if(node==null)
			return l;
		//if the left node is not null
		//then visit the left node first(recursively)
		if(node.left!=null)
			helper(node.left, l);
		//add the node in the list
		l.add(node.val);
		//System.out.print(node.val);
		//check if the right node is not null
		//then visit the right node (recursively)
		if(node.right!=null)
			helper(node.right, l);
		return l;
	}
	
	//to get the number of node in a tree
	public int size(TreeNode node)
	{
		if(node==null)
			return 0;
		return size(node.left) + 1 + size(node.right);
	}

	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		InOrderTraversal rtls = new InOrderTraversal();
		System.out.println(rtls.inorderTraversal(root));
		System.out.println(rtls.size(root));
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
