/* https://leetcode.com/problems/binary-tree-level-order-traversal/ */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class LevelOrderTraversal
{
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		//ArrayList to save the list of all the nodes on the save level
		List<List<Integer>> nodeList = new ArrayList<List<Integer>>();
		//if the root is null
		//then return the empty list
		if(root==null)
		{
			return nodeList;
		}
		//Queue
		//@current to store all the nodes at same level
		LinkedList<TreeNode> current = null;
		//@next to store all the child node at the same level
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		//initially add root to the next
		next.add(root);
		//loop until next is empty
		while(!next.isEmpty())
		{
			//assign next to current
			current = next;
			//@b ArrayList to store the value of the nodes
			ArrayList<Integer> b = new ArrayList<Integer>();
			//initialize next with new LinkedList
			next = new LinkedList<TreeNode>();
			while(!current.isEmpty())
			{
				//remove the element of the current queue
				TreeNode node = current.poll();
				//add the value of the node in the arraylist
				b.add(node.val);
				//if the left node is not null
				//then add left childnode in next queue
				if(node.left!=null)
				{
					next.add(node.left);
				}
				//if the right node is not null
				//then add the right child node in next queue
				if(node.right!=null)
				{
					next.add(node.right);
				}
				//System.out.println(b);
			}
			//add the arraylist b
			nodeList.add(b);
		}
		return nodeList;
    }

	public static void main(String args[])
	{
		LevelOrderTraversal lot = new LevelOrderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		System.out.println(lot.levelOrder(root));
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
		left = null;
		right = null;
	}
}
