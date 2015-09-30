public class RootToLeafSum
{
	public int sumNumbers(TreeNode root) 
	{
        return helper(root, 0);
    }
	
	public int helper(TreeNode root, int sum)
	{
		if(root==null)
		{
			return 0;
		}
		if(root.left == null && root.right==null)
		{
			sum = sum + root.val;
		}
		if(root.left!=null)
		{
			root.left.val = root.val*10+root.left.val;
			System.out.println("left: "+ root.left.val+" sum: "+ sum);
			sum = helper(root.left, sum);
		}
		if(root.right!=null)
		{
			root.right.val = root.val*10 + root.right.val;
			System.out.println("right: "+ root.right.val+" sum: "+sum);
			sum = helper(root.right, sum);
		}
		return sum;
	}
	
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = null;
		root.left.right = null;
		root.right = null;
		// root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);
		// root.right.left = null;
		// root.right.right = null;
		// root.left.left.left = null;
		// root.left.left.right = null;
		// root.left.right.left = null;
		// root.left.right.right = null;
		RootToLeafSum rtls = new RootToLeafSum();
		System.out.println(rtls.sumNumbers(root));
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