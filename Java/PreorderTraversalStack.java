import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class PreorderTraversalStack
{
	public List<Integer> preorderTraversal(TreeNode root) 
    {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return list;
		TreeNode p = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(p);
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
		return list;
    }
	public static void main(String args[])
	{
		PreorderTraversalStack lot = new PreorderTraversalStack();
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(12);
		root.right = new TreeNode(18);
		root.left.left = new TreeNode(7);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(8);
		root.left.left.left.left = new TreeNode(1);
		root.left.left.left.right = new TreeNode(5);
		root.left.left.left.left.right = new TreeNode(2);
		//root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);
		System.out.println(lot.preorderTraversal(root));
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