import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.HashMap;
public class BloodLine
{
	static HashMap<String, TreeNode> map = new HashMap<String, TreeNode>();

	public void bfs(TreeNode parent)
	{
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();

		next.add(parent);
		while(!next.isEmpty())
		{
			curr = next;
			next = new LinkedList<TreeNode>();
			ArrayList<String> childList = new ArrayList<String>();
			ArrayList<TreeNode> children = null;
			while(!curr.isEmpty())
			{
				TreeNode p = curr.poll();
				childList.add(p.name);
				children = p.childs;
				for(TreeNode node: children)
				{
					next.add(node);
					//childList.add(node.name);
				}
			}
			Collections.sort(childList);
			for(String n:childList)
				System.out.print(n+"\t");
			System.out.println();
		}
	}

	public void associate(String parentName, String childName)
	{
		TreeNode parent = null;
		TreeNode childNode = null;
		if(map.containsKey(parentName))
		{
			parent = map.get(parentName);
		}
		else
		{
			parent = new TreeNode(parentName);
			map.put(parentName, parent);
		}
		if(map.containsKey(childName))
		{
			childNode = map.get(childName);
		}
		else
		{
			childNode = new TreeNode(childName);
		}
		map.put(childName, childNode);
		parent.childs.add(childNode);
	}

	public static void main(String args[])
	{
		BloodLine bl = new BloodLine();
		String[] relations = {"mary-bob","sam-x", "bob-john", "mary-sam", "bob-jane", "bob-tom", "bob-tim", "john-viki", "john-tina"};
		for(String relation: relations)
		{
			String parentName = relation.split("-")[0];
			String childName = relation.split("-")[1];
			bl.associate(parentName, childName);
		}
		TreeNode parent = map.get("mary");
		System.out.println(map);
		bl.bfs(parent);
	}
}

class TreeNode
{
	String name;
	ArrayList<TreeNode> childs;

	public TreeNode(String name)
	{
		this.name = name;
		childs = new ArrayList<TreeNode>();
	}
}
