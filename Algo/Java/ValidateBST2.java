/* https://leetcode.com/problems/validate-binary-search-tree/ */
public class ValidateBST2
{
	public boolean isValidBST(TreeNode root)
	{
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean helper(TreeNode root, int min, int max)
	{
		if(root==null)
			return true;
		if(root.val>min && root.val<max
			&& helper(root.left, min, root.val)
			&& helper(root.right, root.val, max))
			{
				System.out.println(min+" "+root.val+" "+max);
				return true;
			}
		else
			return false;
	}

	public static void main(String args[])
	{
		ValidateBST2 v = new ValidateBST2();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		System.out.println(v.isValidBST(root));
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
