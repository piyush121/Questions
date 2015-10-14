/* https://leetcode.com/problems/path-sum-ii/ */
import java.util.List;
import java.util.ArrayList;
class PathSumII
{
	// use dfs to traverse tree recursively and if the sum of the path from root 
	// to leaf is equals to given sum add that path to list
	// use backtracking
	public List<List<Integer>> pathSum(TreeNode root, int sum) 
	{
		List<List<Integer>> pathList = new ArrayList<>();
		if(root==null)
			return pathList;
		List<Integer> path = new ArrayList<>();
        pathSumHelper(root, sum, 0, path, pathList);
        return pathList;
    }

    public void pathSumHelper(TreeNode root, int sum, 
    		int currentSum, List<Integer> path, List<List<Integer>> pathList)
    {
    	if(root!=null)
    	{
    		path.add(root.value);
    		//System.out.println(path);
    		currentSum = currentSum + root.value;
    		if(root.left == null && root.right == null)
    		{
    			if(currentSum == sum)
    			{
    				pathList.add(new ArrayList<Integer>(path));
    			}
    		}
    		else
    		{
    			if(root.left!=null)
    				pathSumHelper(root.left, sum, currentSum, path, pathList);
    			if(root.right!=null)
    				pathSumHelper(root.right, sum, currentSum, path, pathList);
    		}
    		int temp = path.remove(path.size()-1);
    		currentSum = currentSum - temp;
    	}	
    }

	public static void main(String args[])
	{
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		PathSumII p = new PathSumII();
		System.out.println(p.pathSum(root, 22));
	}
}