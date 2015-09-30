import java.util.ArrayList;
import java.util.List;

class PathSum2
{
	List<List<Integer>> list;
	public List<List<Integer>> pathSum(TreeNode root, int sum) 
	{
		list = new ArrayList<List<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		helper(root, sum, 0 , curr);
		return list;
    }
	
	public void helper(TreeNode root, int target, int sum, ArrayList<Integer> curr)
	{
		if(root!=null)
		{
			sum = sum + root.val;
			curr.add(root.val);
			System.out.println(target+" " +sum);
			if(root.left == null && root.right==null)
			{
				if(sum == target)
				{
					list.add(new ArrayList<Integer>(curr));
				}
			}
			else
			{
				if(root.left!=null)
				{
					helper(root.left, target, sum, curr);
				}
				if(root.right!=null)
				{
					helper(root.right, target, sum, curr);
				}
			}
			curr.remove(curr.size()-1);
		}
	}
	
	public static void main(String args[])
	{
		PathSum2 p = new PathSum2();
		TreeNode root=new TreeNode(1);
		int sum =0;
		List<List<Integer>> l = p.pathSum(root, sum);
		System.out.println(l);
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
		this.left = null;
		this.right = null;
	}
}