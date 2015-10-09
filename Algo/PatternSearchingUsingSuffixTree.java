/* http://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/ */
import java.util.Map;
import java.util.HashMap;


public class PatternSearchingUsingSuffixTree
{
	public TrieNode insert(String text)
	{
		TrieNode root = new TrieNode();
		for(int i=0;i<text.length();i++)
		{
			this.insertUtil(root, text.substring(i), 0);
		}
		return root;
	}

	public void insertUtil(TrieNode node, String s, int pos)
	{
		TrieNode temp = null;
		if(node.child.containsKey(s.charAt(pos)))
		{
			temp = node.child.get(s.charAt(pos));
		}
		else
		{
			temp = new TrieNode();
			node.child.put(s.charAt(pos), temp);
		}
		if(pos==s.length()-1)
		{
			temp.isLeaf = true;
			return;
		}
		insertUtil(temp, s, pos+1);
	}

	public boolean searchPattern(TrieNode root, String pattern)
	{
		return searchPatternUtil(root, pattern, 0);
	}

	public boolean searchPatternUtil(TrieNode node, String p, int pos)
	{
		TrieNode temp = null;
		if(pos>p.length()-1)
			return true;
		if(node.child.containsKey(p.charAt(pos)))
		{
			System.out.println("char: "+p.charAt(pos)+" pos: "+pos);
			temp = node.child.get(p.charAt(pos));
			return this.searchPatternUtil(temp, p, pos+1);
		}
		return false;
	}

	public static void main(String args[])
	{
		PatternSearchingUsingSuffixTree p = new PatternSearchingUsingSuffixTree();
		String txt = "geeksforgeeks.org";
		TrieNode root = p.insert(txt);
		System.out.println(root);
		System.out.println(p.searchPattern(root, "geeks"));
	}
}
class TrieNode
{
	boolean isLeaf;
	Map<Character, TrieNode> child;

	TrieNode()
	{
		this.child = new HashMap<>();
	}

	public String toString()
	{
		return this.child.toString()+" : " +this.isLeaf+"\n";
	}
}
