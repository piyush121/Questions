/* https://leetcode.com/problems/kth-smallest-element-in-a-bst/ */
import java.util.List;
import java.util.ArrayList;
class KthSmallestElementinBST
{
	public static void main(String args[])
	{
		KthSmallestElementinBST solution = new KthSmallestElementinBST();
		TreeNode root = solution.new TreeNode(2);
		root.left = solution.new TreeNode(1);
		root.right = solution.new TreeNode(3);
		root.right.right = solution.new TreeNode(5);
		root.right.right.left = solution.new TreeNode(4);

		System.out.println(solution.kthSmallest(root, 3));
	}

	public int kthSmallest(TreeNode root, int k)
	{
		List<Integer> list  = null;
    	if(root==null)
    		return -1;
    	else
    	{
    		list = new ArrayList<Integer>();
    		helper(root, list, k);
    	}
    	//System.out.println(list);
    	return list.get(k-1);
    }

    void helper(TreeNode root, List<Integer> list, int k)
    {
    	if(root.left!=null)
    		helper(root.left, list, k);
    	if(list.size()==k)
    		return;
    	list.add(root.val);
    	if(root.right!=null)
    		helper(root.right, list, k);
    }

	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val)
		{
			this.val = val;
		}
	}
}
