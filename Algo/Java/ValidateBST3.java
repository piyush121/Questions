/* https://leetcode.com/problems/validate-binary-search-tree/ */
public class ValidateBST3
{
	long prev =Long.MIN_VALUE;
	public boolean isValidBST(TreeNode root) 
	{
		TreeNode node = root;
	    return helper(node);
	}

	public boolean helper(TreeNode node)
	{
		if(node==null)
		{
			return true;
		}
		boolean flag = true;
		flag = flag && helper(node.left);
		//System.out.println(prev +" "+node.val);
		if(prev>=node.val)
		{
			//System.out.println("flag: "+flag);
			flag = flag && false;
		}
		else
		{
			//System.out.println("flag: "+flag);
			prev = node.val;
			flag = flag && true;
		}
		flag = flag && helper(node.right);
		return flag;
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