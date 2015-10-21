import java.util.LinkedList;
class TrieNode
{
    private LinkedList<TrieNode> children;
    private boolean end;
    private char val;

    TrieNode()
    {
        children = new LinkedList<TrieNode>();
        this.end = false;
    }

    public void setVal(char c)
    {
        this.val = c;
    }

    public void setEnd(boolean end)
    {
        this.end = end;
    }

    public boolean isEnd()
    {
        return this.end;
    }

    public LinkedList<TrieNode> getChildren()
    {
        return this.children;
    }

    public TrieNode subNode(char c)
    {
        if(children!=null)
        {
            for(TrieNode childNode: children)
            {
                if(childNode.val == c)
                {
                    return childNode;
                }
            }
        }
        return null;
    }
}

public class Trie
{
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
        root.setVal(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word)
    {
        if(search(word))
            return;
        TrieNode current = root;
        for(char c : word.toCharArray())
        {
            TrieNode child = current.subNode(c);
            if(child!=null)
                current = child;
            else
            {
                TrieNode newChild = new TrieNode();
                newChild.setVal(c);
                current.getChildren().add(newChild);
                current = current.subNode(c);
            }
        }
        current.setEnd(true);
    }

    // Returns if the word is in the trie.
    public boolean search(String word)
    {
        TrieNode current = root;
        for(char c : word.toCharArray())
        {
            TrieNode child = current.subNode(c);
            if(child!=null)
                current = child;
            else
                return false;
        }
        if(current.isEnd())
            return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix)
    {
        TrieNode current = root;
        for(char c : prefix.toCharArray())
        {
            TrieNode child = current.subNode(c);
            if(child!=null)
                current = child;
            else
                return false;
        }
        return true;
    }
/*
    public static void main(String args[])
    {
        Trie root = new Trie();
        root.insert("so");
        root.insert("sum");

        System.out.println(root.startsWith("su"));
        System.out.println(root.search("sum"));
    }
*/
}
