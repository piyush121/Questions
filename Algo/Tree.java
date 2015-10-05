import java.util.*;
class Tree
{
	int value;
	Tree left;
	Tree right;

	Tree(int value)
	{
		this.value = value;
	}

	public Tree createTreeFromArray(int[] arr, int low, int high)
	{
		if(low>high)
			return null;
		int mid = low + (high - low)/2;
		Tree root = new Tree(arr[mid]);
		root.left = createTreeFromSortedArray(arr, low, mid-1);
		root.right = createTreeFromSortedArray(arr, mid+1, high);
		return root;
	}

	public void breadFirstSearch(Tree root)
	{
		Tree p = root;
		ArrayDeque<Tree> queue = new ArrayDeque<Tree>();
		if(p==null)
		{
			return;
		}
		else
		{
			queue.add(p);
		}
		while(!queue.isEmpty())
		{
			Tree node = queue.poll();
			System.out.print(node.value+"\t");
			if(node.left!=null)
			{
				queue.add(node.left);
			}
			if(node.right!=null)
			{
				queue.add(node.right);
			}
		}
	}

	public void depthFirstSearch(Tree root)
	{
		System.out.println();
		Tree p = root;

		if(p==null)
		{
			return;
		}
		Stack<Tree> stack = new Stack<Tree>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(p.value);
		stack.push(p);
		while(!stack.isEmpty())
		{
			Tree node = stack.pop();
			System.out.print(node.value +"\t");
			if(node.right!=null)
			{
				stack.push(node.right);
			}
			if(node.left!=null)
			{
				stack.push(node.left);
			}

		}
	}

	public void toLinkedList(Tree root)
	{
		Stack<Tree> stack = new Stack<Tree>();
		Tree p = root;
		while(p!=null || !stack.isEmpty())
		{
			if(p.right!=null)
			{
				stack.push(p.right);
			}
			if(p.left!=null)
			{
				p.right = p.left;
				p.left = null;
			}
			else if(!stack.isEmpty())
			{
				Tree temp = stack.pop();
				p.right = temp;
			}
			p = p.right;
		}
	}

	public static void main(String arg[])
	{
		Tree t = new Tree(0);
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Tree root = t.createTreeFromSortedArray(a, 0, a.length-1);
		t.breadFirstSearch(root);
		//t.toLinkedList(root);
		//System.out.println();
		//t.breadFirstSearch(root);
		t.depthFirstSearch(root);
	}
}
