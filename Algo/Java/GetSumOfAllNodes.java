/*
	Given a list of node in which each node contains two pointers "next" and "branch". "next" and "branch" pointer again point to a linked list of similar nodes. A "branch" pointer of a node can be null. However, a "next" pointer is null only for the last node in the linked-list. Get the sum of all the nodes
*/
import java.util.Stack;

public class GetSumOfAllNodes
{
	public static void main(String[] args)
	{
		GetSumOfAllNodes g = new GetSumOfAllNodes();
		GNode g1 = new GNode(1);
		g1.next = new GNode(2);
		g1.next.next = new GNode(3);
		g1.next.next.next = new GNode(4);
		g1.next.next.next.next = new GNode(5);


		g1.next.next.branch = new GNode(6);
		g1.next.next.branch.next = new GNode(7);

		g1.next.next.next.branch = new GNode(8);
		g1.next.next.next.branch.next = new GNode(9);
		System.out.println(g.getSum(g1));
	}

	public int getSum(GNode node)
	{
		Stack<GNode> stack = new Stack<GNode>();
		stack.push(node);
		int sum = 0;
		while(!stack.isEmpty())
		{
			GNode temp = stack.pop();
			while(temp!=null)
			{
				sum += temp.value;
				if(temp.branch!=null)
					stack.push(temp.branch);
				temp = temp.next;
			}
		}
		return sum;
	}
}

class GNode
{
	GNode next;
	GNode branch;
	int value;

	GNode(int value)
	{
		this.value = value;
	}
}
