/* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/ */
import java.util.Stack;
public class FlattenBinaryTreeToLinkedList
{
	public void flatten(TreeNode root) 
	{
        if(root == null)
        	return;
        Stack<TreeNode> stack = new Stack<>();
        helper(root, stack);
    }

    public void helper(TreeNode root, Stack<TreeNode> stack)
    {
    	if(root.left!=null)
    	{
    		if(root.right!=null)
    			stack.push(root.right);
    		System.out.println("stack: "+stack);
    		root.right = root.left;
    		root.left = null;
    		helper(root.right, stack);
    	}
    	if(root.right!=null)
    	{
    		helper(root.right, stack);
    	}
    	if(!stack.isEmpty())
    	{
    		root.right = stack.pop();
    		helper(root.right, stack);
    	}
    }

    public void inorderTraversal(TreeNode root)
    {
    	if(root==null)
    		return;
    	if(root.left!=null)
    		inorderTraversal(root.left);
    	System.out.print(root.val + " ");
    	if(root.right!=null)
    		inorderTraversal(root.right);
    }

    public static void main(String args[])
    {
    	FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(5);
    	//root.right.left = new TreeNode(6);
    	root.left.left = new TreeNode(3);
    	root.left.right = new TreeNode(4);
    	root.right.right = new TreeNode(6);
    	f.inorderTraversal(root);
    	System.out.println();
    	f.flatten(root);
    	f.inorderTraversal(root);
    	System.out.println();
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
	}

	public String toString()
	{
		return this.val+"";
	}
}