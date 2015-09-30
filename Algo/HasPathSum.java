public class HasPathSum
{
	public boolean hasPathSum(TreeNode root, int sum) 
	{
        return helper(root, sum, 0);
    }
	
	public boolean helper(TreeNode root, int target, int sum)
	{
		if(root==null)
			return false;
		sum = sum + root.val;
		if(root.left ==null && root.right==null)
		{
			if(sum == target)
			{
				return true;
			}
		}
		boolean leftTree  = helper(root.left, target, sum);
		boolean rightTree = helper(root.right, target, sum);
		if(leftTree || rightTree)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String args[])
	{
		HasPathSum hps = new HasPathSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(hps.hasPathSum(root, 3));
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