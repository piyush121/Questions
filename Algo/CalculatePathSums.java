public class CalculatePathSums
{
	public static void main(String s[]) 
	{
		Node root = new Node(6);
		Node l11 = new Node(3);
		Node l12 = new Node(5);
		root.left = l11;
		root.right = l12;
		Node l21 = new Node(2);
		Node l22 = new Node(5);
		Node l23 = new Node(4);
		l11.left = l21;
		l11.right = l22;
		l12.right = l23;
		Node l31 = new Node(7);
		Node l32 = new Node(4);
		l22.left = l31;
		l22.right = l32;
		int sum = findSum(root, 0);
		System.out.println(sum);
	}
	
	public static int breadFirstSearch(Node root, int sum)
	{
		if(root.right == null && root.left=null)
		{
			sum = sum + root.data;
		}
		if(root.right!=null)
		{
			root.right.data = root.data*10 + root.right.data;
			sum = findSum(root.right, sum);
		}
		if(root.left !=null)
		{
			root.left.data = root.data*10+root.left.data;
			sum = findSum(root.left, sum);
		}
		return sum;
	}
	
	static int findSum(Node root, int sum)
	{
		if(root.right == null && root.left == null)
			sum = sum + root.data;
		
		if(root.right != null) {
			root.right.data = root.data*10 + root.right.data;
			sum = findSum(root.right, sum);
		}
		if(root.left != null) {
			root.left.data = root.data*10 + root.left.data;
			sum = findSum(root.left, sum);
		}
		
		return sum;
	}
}

class Node 
{
	int data;
	Node right;
	Node left;
	
	Node(int data) 
	{
		this.data = data;
		this.right = null;
		this.left = null;
	}
}

class Pair
{
	Node node;
	String str;
	
	Pair(Node node, String str)
	{
		this.node = node;
		this.str = str;
	}
}