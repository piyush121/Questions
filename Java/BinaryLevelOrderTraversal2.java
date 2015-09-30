import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
public class BinaryLevelOrderTraversal2
{
	public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        TreeNode node = root;
		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		if(node==null)
		{
			list.add(new ArrayList<Integer>());
			return list;
		}
		LinkedList<TreeNode> curr = null;
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		next.add(node);
		while(!next.isEmpty())
		{
			curr = next;
			next = new LinkedList<TreeNode>();
			ArrayList<Integer> l = new ArrayList<Integer>();
			while(!curr.isEmpty())
			{
				TreeNode temp = curr.remove();
				l.add(temp.val);
				if(temp.left!=null)
					next.add(temp.left);
				if(temp.right!=null)
					next.add(temp.right);
			}
			stack.push(l);
		}
		while(!stack.isEmpty())
		{
			list.add(stack.pop());
		}
		return list;
    }
	
	public static void main(String args[])
	{
		BinaryLevelOrderTraversal2 b = new BinaryLevelOrderTraversal2();
		TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);
		// root.right.right = new TreeNode(6);
		// root.left.left.left = new TreeNode(7);
		// root.left.left.right = new TreeNode(8);
		// root.left.right.left = new TreeNode(9);
		// root.left.right.left.left = new TreeNode(17);
		// root.left.right.left.right = new TreeNode(18);
		// root.left.right.right = new TreeNode(10);
		// root.left.right.right.left = new TreeNode(13);
		// root.left.right.right.right = new TreeNode(14);
		// root.right.right.left = new TreeNode(11);
		// root.right.right.right = new TreeNode(12);
		// root.right.right.left.right = new TreeNode(15);
		// root.right.right.right.right = new TreeNode(16);
		System.out.println(b.levelOrderBottom(root));
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