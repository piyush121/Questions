/* https://leetcode.com/problems/binary-tree-paths/ */
import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths
{
    public static void main(String args[])
    {
        BinaryTreePaths bt = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(bt.binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> pathList = new ArrayList<>();
        if(root==null)
            return pathList;
        return helper(root, root.val+"", pathList);
    }

    public List<String> helper(TreeNode root, String path, List<String> pathList)
    {
        if(root.left==null && root.right == null)
        {
            pathList.add(path);
            //return pathList;
        }
        else
        {
            //path = path + "->" + root.val;
            if(root.left!=null)
                helper(root.left, path+"->"+root.left.val, pathList);
            if(root.right!=null)
                helper(root.right, path+"->"+root.right.val, pathList);
        }
        return pathList;
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
