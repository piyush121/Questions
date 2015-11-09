/* http://www.geeksforgeeks.org/interval-tree/ */
import java.util.List;
import java.util.ArrayList;
public class IntervalTree
{
	public ITreeNode insert(ITreeNode root, Interval i)
	{
		if(root==null)
			return new ITreeNode(i);

		if(root.interval.lo > i.lo)
			root.left = insert(root.left , i);
		else
			root.right = insert(root.right, i);

		if(root.max < i.hi)
			root.max = i.hi;

		return root;
	}

	public boolean doOverlap(Interval i1, Interval i2)
	{
		if((i1.lo <= i2.hi) && (i2.lo <= i1.hi))
			return true;
		return false;
	}

	public List<Interval> searchOverlapping(ITreeNode root, Interval i, List<Interval> list)
	{
		if(root == null)
		{
			return list;
		}
		if(root.left == null && root.right==null)
		{
			return list;
		}

		if(this.doOverlap(root.interval, i))
		{
			list.add(root.interval);
		}
		if(root.left!=null && root.left.max >= i.lo)
				searchOverlapping(root.left, i, list);
		searchOverlapping(root.right, i, list);
		return list;
	}

	public static void main(String args[])
	{
		IntervalTree iTree = new IntervalTree();
		int intr[][] = {
						{15, 20}, {10, 30}, 
						{17, 19}, {5, 20}, 
						{12, 15}, {30, 40}
    				 };
    	ITreeNode root = null;
    	for(int i=0;i<intr.length;i++)
	    {
	    	root = iTree.insert(root, new Interval(intr[i][0], intr[i][1]));
    	}
    	iTree.inorder(root);

    	Interval x = new Interval(16, 21);
    	System.out.println(iTree.searchOverlapping(root, x, new ArrayList<Interval>()));
	}

	public void inorder(ITreeNode root)
	{
		if(root.left!=null)
			inorder(root.left);
		System.out.println(root);
		if(root.right!=null)
			inorder(root.right);
	}
}
class ITreeNode 
{
	Interval interval;
	ITreeNode left;
	ITreeNode right;
	int max;

	public ITreeNode(Interval i)
	{
		interval = i;
		max = i.hi;
	}

	public String toString()
	{
		return interval.toString();
	} 
}
class Interval
{
	int lo;
	int hi;

	public Interval(int lo, int hi)
	{
		this.lo = lo;
		this.hi = hi;
	}

	public String toString()
	{
		return "["+this.lo +", "+this.hi+"]";
	}

}