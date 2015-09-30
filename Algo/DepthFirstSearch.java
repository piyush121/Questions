import java.util.Stack;
public class DepthFirstSearch
{
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        DepthFirstSearch d = new DepthFirstSearch();
        d.dfsIterative(root);
        System.out.println();
        d.dfsRecursive(root);
        System.out.println();
    }

    public void dfsRecursive(TreeNode root)
    {
        System.out.print(root.val+"\t");
        if(root.left!=null)
            dfsRecursive(root.left);
        if(root.right!=null)
            dfsRecursive(root.right);
    }

    public void dfsIterative(TreeNode root)
    {
        if(root==null)
            return;
        TreeNode p1 = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(p1);
        while(!stack.isEmpty())
        {
            TreeNode v = stack.pop();
            if(v.visited == false)
            {
                v.visited = true;
                System.out.print(v.val+"\t");
                if(v.right!=null)
                    stack.push(v.right);
                if(v.left!=null)
                    stack.push(v.left);
            }
        }
        //System.out.println();
    }
}


class TreeNode
{
    TreeNode left;
    TreeNode right;
    int val;
    boolean visited;

    TreeNode(int val)
    {
        this.val = val;
        this.visited = false;
        this.left = null;
        this.right = null;
    }
}
