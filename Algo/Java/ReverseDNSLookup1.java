public class ReverseDNSLookup
{
	public int getIndex(char c)
	{
		return c=='.'?10:c-'0';
	}

	public void insert(TrieNode root, String ip, String url)
	{
		if(root==null)
			return;
		TrieNode p = root;
		for(int level = 0; level<ip.length();level++)
		{
			int index = getIndex(ip.charAt(level));
			if(p.children[index]==null)
				p.children[index] = new TrieNode();
			p = p.children[index];
		}
		p.isLeaf = true;
		p.url =url;
	}

	public String search(TrieNode root, String ip)
	{
		if(root==null)
			return null;
		TrieNode p = root;
		for(int level = 0;level<ip.length();level++)
		{
			int index = getIndex(ip.charAt(level));
			if(p.children[index]==null)
				return null;
			p = p.children[index];
		}

		if(p!=null && p.isLeaf==true)
		{
			return p.url;
		}
		return null;
	}

	public static void main(String args[])
	{
		TrieNode root = new TrieNode();
		ReverseDNSLookup l = new ReverseDNSLookup();
		l.insert(root, "11.121.22.11", "www.samsung.com");
		l.insert(root, "1.1.1.1", "www.google.com");
		l.insert(root, "8.8.8.0", "www.facebook.com");

		System.out.println(l.search(root, "1.1.1.1"));
		System.out.println(l.search(root, "11.121.22.11"));
	}
}

class TrieNode
{
	String url;
	boolean isLeaf;
	TrieNode[] children;

	public TrieNode()
	{
		this.isLeaf = false;
		children = new TrieNode[11]; //0-9 for digits and 10 for '.'
	}
}
