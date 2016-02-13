/* https://leetcode.com/problems/binary-tree-paths/ */
/* 
  1
/   \
2    3
 \
  5
    return all root-to-leaf paths
    ["1->2->5", "1->3"] */
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
        //ArrayList to maintain the list of all the paths
        List<String> pathList = new ArrayList<>();
        //if the root is null return empty ArrayList
        if(root==null)
            return pathList;
        return helper(root, root.val+"", pathList);
    }

    public List<String> helper(TreeNode root, String path, List<String> pathList)
    {
        //if the left node is null and the right node is null
        //then we have reached the leaf node, add the path in the pathlist
        if(root.left==null && root.right == null)
        {
            pathList.add(path);
            //return pathList;
        }
        else
        {
            //path = path + "->" + root.val;
            //if the left node of the tree is not null
            //then recursively call helper function, with node details appended
            //to the path 
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
