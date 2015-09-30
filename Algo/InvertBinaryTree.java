import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
public class InvertBinaryTree
{
    public static void main(String args[])
    {
        InvertBinaryTree i = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(i.levelOrder(root));

        i.invertTree(root);
        System.out.println(i.levelOrder(root));
    }

    public TreeNode invertTree(TreeNode root)
    {
        helper(root);
        return root;
    }

    public void helper(TreeNode root)
    {
        if(root==null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }

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
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x)
    {
        val = x;
    }
}
