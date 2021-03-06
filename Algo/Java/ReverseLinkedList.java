/* https://leetcode.com/problems/reverse-linked-list/ */
public class ReverseLinkedList
{
	static LinkNode p = null;
	//iterative solution 
	//take three pointers 
	//@curr : to point the current node starting from head
	//@prev : to point previous node starting from null
	//@next : to point to next node starting from null and updated to point 
	// curr.next in the subsequent iteration
	public LinkNode iterative(LinkNode head)
	{
		LinkNode prev = null;
		LinkNode curr = head;
		LinkNode next = null;
		// loop until current pointer doesn't point to null i.e. end of the 
		//linked list
		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	//recursive implementation of the above iterative solution
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
		//if head == null there is no node in the linked list
		if(head==null)
			return;
		//take two pointers first and rest
		//@first : initially points to the head of the list
		//@rest : initially points to head.next
		LinkNode first = head;
		LinkNode rest = first.next;
		//if rest == null there is only single node in the linked list
		// or we have reached the end of the linkedlist
		//terminating condition
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
