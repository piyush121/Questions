/* http://www.geeksforgeeks.org/print-right-view-binary-tree-2/ */
/* https://leetcode.com/problems/binary-tree-right-side-view/ */

import java.util.List;
import java.util.ArrayList;

class RightSideViewOfBTree
{
	//global variable to persist the value between recursive calls
	static int max;
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		//root.right = new TreeNode(3);

		//root.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);

		//root.left.left.left = new TreeNode(8);
		//root.right.right.right = new TreeNode(9);

		//root.left.left.left.left = new TreeNode(10);

		RightSideViewOfBTree r = new RightSideViewOfBTree();
		r.usingLevelOrderTraversal(root);
		System.out.println();
		List<Integer> list = new ArrayList<>();
		r.simpleRecursion(root, 1, list);
		System.out.println(list);
	}

	public void usingLevelOrderTraversal(TreeNode node)
	{
		if(node==null)
			return;
		List<TreeNode> list1 = new ArrayList<>();
		List<List<TreeNode>> list2 = new ArrayList<>();
		System.out.print(node.value+" ");
		list1.add(node);
		list2.add(list1);
		while(!list2.isEmpty())
		{
			List<TreeNode> next = new ArrayList<>();
			List<TreeNode> curr = list2.remove(0);

			while(!curr.isEmpty())
			{
				TreeNode r = curr.remove(0);
				if(r.left!=null)
					next.add(r.left);
				if(r.right!=null)
					next.add(r.right);
			}
			if(!next.isEmpty())
			{
				System.out.print(next.get(next.size()-1).value+" ");
				list2.add(next);
			}
		}
	}

	public void simpleRecursion(TreeNode node, int level, List<Integer> list)
	{
		if(node==null)
		{
			return;
		}
		if(max < level)
		{
			System.out.print(node.value+" ");
			list.add(node.value);
			max = level;
		}

		simpleRecursion(node.right, level+1, list);
		simpleRecursion(node.left, level+1, list);
	}
}
