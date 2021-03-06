/* http://www.geeksforgeeks.org/mirror-of-n-ary-tree/?utm_source=feedburner&utm_medium=email&utm_campaign=Feed%3A+Geeksforgeeks+%28GeeksforGeeks%29 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class MirrorOfnAryTree
{
	public void mirrorTree(NTree root)
	{
		if(root == null)
			return;
		LinkedList<NTree> currList = new LinkedList<>();
		currList.add(root);
		while(!currList.isEmpty())
		{
			NTree node = currList.removeFirst();
			Collections.reverse(node.child);
			for(NTree n : node.child)
				currList.add(n);
		}
	}

	public void printTree(NTree node)
	{
		LinkedList<NTree> currList = null;
		LinkedList<NTree> nextList = new LinkedList<>();
		nextList.add(node);
		while(!nextList.isEmpty())
		{
			currList = new LinkedList<>(nextList);
			nextList = new LinkedList<>();
			while(!currList.isEmpty())
			{
				NTree n = currList.removeFirst();
				System.out.print(n.val+"\t");
				for(NTree childNode:n.child)
					nextList.add(childNode);
			}
			System.out.println();
		}
 	}

	public static void main(String args[])
	{
		MirrorOfnAryTree m = new MirrorOfnAryTree();
		NTree root = new NTree(10);
		root.child.add(new NTree(2));
		root.child.add(new NTree(34));
		root.child.add(new NTree(56));
		root.child.add(new NTree(100));
		root.child.get(1).child.add(new NTree(1));
		root.child.get(3).child.add(new NTree(7));
		root.child.get(3).child.add(new NTree(8));
		root.child.get(3).child.add(new NTree(9));
		m.printTree(root);
		m.mirrorTree(root);
		m.printTree(root);
	}
}

class NTree
{
	int val;
	List<NTree> child;

	NTree(int val)
	{
		this.val = val;
		this.child = new ArrayList<>();
	}
}