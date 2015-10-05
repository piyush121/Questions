import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class LevelOrderTraversal
{
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> nodeList = new ArrayList<List<Integer>>();
		if(root==null)
		{
			return nodeList;
		}
		LinkedList<TreeNode> current = null;
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		next.add(root);
		while(!next.isEmpty())
		{
			current = next;
			ArrayList<Integer> b = new ArrayList<Integer>();
			next = new LinkedList<TreeNode>();
			while(!current.isEmpty())
			{
				TreeNode node = current.poll();
				b.add(node.val);
				if(node.left!=null)
				{
					next.add(node.left);
				}
				if(node.right!=null)
				{

					next.add(node.right);
				}
				//System.out.println(b);
			}
			nodeList.add(b);
		}
		return nodeList;
    }

	public static void main(String args[])
	{
		LevelOrderTraversal lot = new LevelOrderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		System.out.println(lot.levelOrder(root));
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
