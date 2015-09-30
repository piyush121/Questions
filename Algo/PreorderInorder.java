import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class PreorderInorder
{
	static int p = 0;
	public static void main(String args[])
	{
		int[] preorder = {1, 2};// 3, 5, 4};
		int[] inorder = {1, 2};//;, 3, 4, 5};
		PreorderInorder solution = new PreorderInorder();
		InOrderTraversal i = new InOrderTraversal();
		List<Integer> list = i.inorderTraversal(solution.buildTree(preorder, inorder));
		System.out.println(list);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) 
	{
		if(preorder==null || preorder.length==0)
			return null;
		if(preorder.length==1)
			return new TreeNode(preorder[0]);
		Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
        	map.put(inorder[i], i);
        }
        TreeNode root = construct(0, inorder.length-1, preorder, map);
        return root;
    }

    public TreeNode construct(int start, int end, int[] preorder, Map<Integer, Integer> map)
    {
    	if(start>end)
    		return null;
    	TreeNode root = determineRoot(preorder);
    	if(root!=null)
    	{
    		root.left = construct(start, map.get(root.val)-1, preorder, map);
    		root.right = construct(map.get(root.val)+1, end, preorder, map); 
    	}
    	return root;
    }

    public TreeNode determineRoot(int[] preorder)
    {	
    	TreeNode root = null;
    	if(p<preorder.length)
    	{
    		root = new TreeNode(preorder[p]);
    		p++;
    	}
    	return root;
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
	}
}