public class LowestCommonAncestorInABST
{
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LowestCommonAncestorInABST l = new LowestCommonAncestorInABST();
        TreeNode node = l.lowestCommonAncestor(root, root.left, root.left.right);
        System.out.println(node.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root.val==p.val || root.val==q.val || (root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val))
            return root;
        else if(root.val > p.val && root.val > q.val)
            return helper(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return helper(root.right, p, q);
        return root;
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
