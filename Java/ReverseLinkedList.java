public class ReverseLinkedList
{
	static LinkNode p = null;
	public LinkNode iterative(LinkNode head)
	{
		LinkNode prev = null;
		LinkNode curr = head;
		LinkNode next = null;
		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public LinkNode recursive(LinkNode prev, LinkNode curr, LinkNode next)
	{
		if(curr==null)
			return prev;
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
		return recursive(prev, curr, next);	
	}
	
	public void recursive2(LinkNode head)
	{
		if(head==null)
			return;

		LinkNode first = head;
		LinkNode rest = first.next;
		if(rest==null)
			return;
		recursive2(rest);
		first.next.next = first;
		first.next = null;
		if(p==null)
			p = rest;
	}
	
	public static void main(String args[])
	{
		LinkNode head = new LinkNode(1);
		head.next = new LinkNode(2);
		head.next.next = new LinkNode(3);
		head.next.next.next = new LinkNode(4);
		ReverseLinkedList r = new ReverseLinkedList();
		//head = r.iterative(head);
		//head = r.recursive(null, head, null);
		r.recursive2(head);
		r.printLinkedList(p);
	}
	
	public void printLinkedList(LinkNode head)
	{
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}

class LinkNode
{
	LinkNode next;
	int val;
	
	public LinkNode(int val)
	{	
		this.val = val;
		this.next = null;
	}
}