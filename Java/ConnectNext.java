import java.util.LinkedList;
public class ConnectNext
{
	public void connect(TreeLinkNode root) {
        if(root == null)
			return;
		if(root.left==null && root.right==null)
		{
			return;
		}
        LinkedList<TreeLinkNode> curr;
		LinkedList<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
		TreeLinkNode node = root;
		next.add(node);
		
		while(!next.isEmpty())
		{
			curr = next;
			next = new LinkedList<TreeLinkNode>();
			TreeLinkNode prev = new TreeLinkNode(Integer.MIN_VALUE);
			while(!curr.isEmpty())
			{
				TreeLinkNode p = curr.remove();
				if(prev.val!=Integer.MIN_VALUE)
				{
					prev.next = p;
				}
				prev = p;
				if(p.left!=null)
					next.add(p.left);
				if(p.right!=null)
					next.add(p.right);
			}
		}
    }
}
class TreeLinkNode
{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) 
	{ 
		this.val = x;
		this.left = null;
		this.right = null;
		this.next = null;
	}
}
