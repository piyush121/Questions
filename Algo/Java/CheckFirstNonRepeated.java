import java.util.HashMap;
class Node
{
	public Node next;
	public Node prev;
	public String value;

	Node(String value)
	{
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
public class CheckFirstNonRepeated
{
	static HashMap<String, Node> map = new HashMap<String, Node>();
	static String s = "the angry dog was red and the cat was also angry";

	public static void main(String args[])
	{
		String[] temp = s.split(" ");
		Node head = new Node("-1");
		Node last = head;
		for(String word:temp)
		{
			printLinkedList(head);
			if(!map.containsKey(word))
			{
				Node newNode = new Node(word);
				last.next = newNode;
				newNode.prev = last;
				last = newNode;
				map.put(word, newNode);
			}
			else if(map.containsKey(word))
			{
				Node n = map.get(word);
				System.out.print("n: "+n.value+"\n");
				System.out.print("n.prev: "+n.prev.value+"\n");
				System.out.print("n.next: "+n.next.value+"\n");
				if(last==n)
				{
					System.out.print("last: "+last+"\n");
					last = n.prev;
				}
				n.prev.next = n.next;
				n.next.prev = n.prev;
				n.prev = null;
				map.remove(word);
			}
		}
		System.out.println(head.next.value);
	}

	public static void printLinkedList(Node head)
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.value+"\t");
			temp = temp.next;
		}
		System.out.println();
	}

}
