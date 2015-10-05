import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class PostorderTraversal
{
	public List<Integer> postorderTraversal(TreeNode root)
	{
		List<Integer> l = new ArrayList<Integer>();
		if(root==null)
			return l;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> reverseStack = new Stack<Integer>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			reverseStack.push(node.val);
			if(node.left!=null)
				stack.push(node.left);
			if(node.right!=null)
				stack.push(node.right);
		}
		//System.out.println(reverseStack);
		while(!reverseStack.isEmpty())
		{
			l.add(reverseStack.pop());
		}
		return l;
    }

	public static void main(String args[])
	{
		PostorderTraversal p = new PostorderTraversal();
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
		System.out.println(p.postorderTraversal(root));
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
