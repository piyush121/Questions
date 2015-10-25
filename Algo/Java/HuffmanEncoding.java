/* Huffman Encoding */
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

public class HuffmanEncoding
{

	private Queue<HTreeNode> pQueue;
	private Map<Character, String> encodingMap;

	HuffmanEncoding(Map<Character, Integer> freqMap)
	{
		this.pQueue = new PriorityQueue<>();
		for(Entry<Character, Integer> entry:freqMap.entrySet())
		{
			HTreeNode node = new HTreeNode(entry.getKey(), entry.getValue());
			pQueue.add(node);
		}
		this.encodingMap = new HashMap<>();
	}

	private HTreeNode buildHuffmanTree()
	{
		while(this.pQueue.size()!=1)
		{
			HTreeNode n1 = this.pQueue.poll();
			HTreeNode n2 = this.pQueue.poll();

			HTreeNode n3 = new HTreeNode('#', n1.freq + n2.freq);
			n3.left = n1;
			n3.right = n2;
			this.pQueue.add(n3);
		}
		return this.pQueue.poll();
	}

	private void getEncodingMap(HTreeNode node, String encoding)
	{
		if(node.left==null && node.right==null)
		{
			encodingMap.put(node.c, encoding);
			return;
		}
		if(node.left!=null)
			getEncodingMap(node.left, encoding+"0");
		if(node.right!=null)
			getEncodingMap(node.right, encoding+"1");
	}

	public static void main(String args[])
	{
		Map<Character, Integer> freqMap = new HashMap<>();
		freqMap.put('a', 4);
		freqMap.put('e', 4);
		freqMap.put('f', 3);
		freqMap.put('h', 2);
		freqMap.put('i', 2);
		freqMap.put('m', 2);
		freqMap.put('n', 2);
		freqMap.put('s', 2);
		freqMap.put('t', 2);
		freqMap.put('l', 1);
		freqMap.put('o', 1);
		freqMap.put('x', 1);
		HuffmanEncoding h = new HuffmanEncoding(freqMap);
		HTreeNode root = h.buildHuffmanTree();
		h.getEncodingMap(root, "");
		System.out.println(h.encodingMap.toString());
		//while(!h.pQueue.isEmpty())
		//s	System.out.println(h.pQueue.poll());
	}
}

class HTreeNode implements Comparable<HTreeNode>
{
	HTreeNode left;
	HTreeNode right;

	int freq;
	char c;

	HTreeNode(char c, int freq)
	{
		this.c = c;
		this.freq = freq;
	}

	@Override
    public int compareTo(HTreeNode node)
    {
    	return this.freq - node.freq;
    }

    @Override
    public String toString()
    {
    	return this.left + " " +this.right+ " " + this.c + " " + this.freq;
    }

}
