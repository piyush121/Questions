import java.util.List;
import java.util.ArrayList;
public class SortedArrayToBST
{
	public TreeNode sortedArrayToBST(int[] num)
	{
		if(num.length==0)
			return null;
		return helper(num, 0, num.length-1);
    }

	public TreeNode helper(int[] num, int lo, int hi)
	{
		//System.out.println("lo: "+lo+" hi: "+hi);
		if(lo>hi)
			return null;
		int mid = lo +(hi-lo)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, lo, mid-1);
		root.right = helper(num, mid+1, hi);
		return root;
	}



	public List<Integer> inorderTraversal(TreeNode root)
	{
		TreeNode node = root;
		ArrayList<Integer> l = new ArrayList<Integer>();
		return helper(node, l);
    }

	public List<Integer> helper(TreeNode node, List<Integer> l)
	{
		if(node==null)
			return l;
		if(node.left!=null)
			helper(node.left, l);
		l.add(node.val);
		//System.out.print(node.val);
		if(node.right!=null)
			helper(node.right, l);
		return l;
	}

	public static void main(String args[])
	{
		SortedArrayToBST s = new SortedArrayToBST();
		int[] a = {1, 2 ,3, 4, 5, 6, 7};
		TreeNode root = s.sortedArrayToBST(a);
		System.out.println(s.inorderTraversal(root));
	}
}
class TreeNode
{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int val)
	{
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
