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
		if(node==null)
			return l;
		if(node.left!=null)
			helper(node.left, l);
		l.add(node.val);
		//System.out.print(node.val);
		if(node.right!=null)
			helper(node.right, l);
		return l;
	}
	
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