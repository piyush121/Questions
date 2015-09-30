import java.util.*;
class BinaryTree
{
	private BinaryTree left;
	private BinaryTree right;
	private int value;
	
	public BinaryTree(int value)
	{
		this.value = value;
		this.left = null;
		this.right = null;
	}
	//construct a binary tree from sorted array
	public static BinaryTree constructBinaryTree(int[] a, int lo, int hi)
	{
		if(lo>hi)
			return null;
		int mid = lo + (hi - lo)/2;
		BinaryTree root = new BinaryTree(a[mid]);
		root.left = constructBinaryTree(a, lo, mid-1);
		root.right = constructBinaryTree(a, mid+1, hi);
		return root;
	}
	
	
	public static void breadthFirstSearch(BinaryTree root)
	{
		if(root == null)
			return;
		BinaryTree node = root;
		LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
		LinkedList<BinaryTree> next =new LinkedList<BinaryTree>();
		queue.add(node);
		while(!queue.isEmpty())
		{
			for(BinaryTree temp: queue)
			{
				//temp = queue.remove();
				System.out.print(temp.value+"\t");
				if(temp.left!=null)
					next.add(temp.left);
				if(temp.right!=null)
					next.add(temp.right);
			}
			System.out.println();
			queue = next;
			next = new LinkedList<BinaryTree>();
		}
	}
	
	public static void main(String args[])
	{
		int a[] = {1, 2,3, 4, 5, 6, 7, 8, 9, 10};
		BinaryTree b = BinaryTree.constructBinaryTree(a, 0, a.length-1);
		BinaryTree.breadthFirstSearch1(b);
		//System.out.println(BinaryTree.findLCA(b, 2,5).value);
	}
	
	public static void toLinkedList(BinaryTree root)
	{
		if(root == null)
			return;
		BinaryTree node = root;
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		while(node!=null || !stack.isEmpty())
		{
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
			{
				node.right = node.left;
				node.left = null;
			}
			else if(!stack.isEmpty())
			{
				BinaryTree temp = stack.pop();
				node.right = temp;
			}
			node = node.right;
		}
	}
	
	public static BinaryTree findLCA(BinaryTree node, int n1, int n2)
	{
		if(node==null)
			return null;
		if(node.value ==n1 || node.value==n2)
		{
			return node;
		}
		BinaryTree left = findLCA(node.left,n1,n2);
		BinaryTree right = findLCA(node.right,n1,n2);
		if(left!=null || right!=null)
		{
			return node;
		}
		if(left!=null)
			return left;
		else
			return right;
	}
	
	public static void breadthFirstSearch1(BinaryTree root)
	{
		if(root == null)
			return;
		BinaryTree node = root;
		LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
		LinkedList<BinaryTree> next =new LinkedList<BinaryTree>();
		queue.add(node);
		int count=1;
		int maxVal = node.value;
		while(!queue.isEmpty())
		{
			for(BinaryTree temp: queue)
			{
				//temp = queue.remove();
				System.out.print(temp.value+"\t");
				int val = temp.value;
				if(temp.left!=null)
				{
					next.add(temp.left);
				}
				if(temp.right!=null)
				{
					next.add(temp.right);
				}
			}
			System.out.println();
			queue = next;
			next = new LinkedList<BinaryTree>();
		}
	}
}