public class InsertionSortList
{
	public ListNode insertionSortList(ListNode head)
	{
		if(head==null)
			return null;
		ListNode endNode = head;
		ListNode a = head;
		while(endNode!=null)
		{
			//a = endNode;
			if(a.next!=null)
			{
				if(a.val>a.next.val)
				{
					ListNode b = a.next;
					a.next = b.next;
					printList(head);
					System.out.println(b.val);
					head = insertNode(b, head);
				}
			}
			//if(a.next!=null)
			//	a = a.next;
			endNode = endNode.next;
		}
		printList(head);
		return head;
    }

	public ListNode insertNode(ListNode inode, ListNode head)
	{
		ListNode a = head;
		while(a.val<inode.val)
		{
			a = a.next;
		}
		System.out.println(a.val);
		ListNode b = head;
		System.out.println(b.val);
		if(b==a)
		{
			//insert at the head of the list
			inode.next = a;
			head = inode;
		}
		else
		{
			while(b.next!=a)
			{
				b = b.next;
			}
			b.next = inode;
			inode.next = a;
		}
		return head;
	}

	public void printList(ListNode head)
	{
		ListNode a = head;
		while(a!=null)
		{
			System.out.print(a.val+"\t");
			a = a.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		InsertionSortList isl = new InsertionSortList();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		//head.next.next.next = new ListNode(1);
		//head.next.next.next.next = new ListNode(2);
		isl.printList(head);
		isl.insertionSortList(head);

		ListNode head1 = new ListNode(3);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(1);
		isl.printList(head1);
		isl.insertionSortList(head1);

	}
}

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
	{
        val = x;
        next = null;
    }
}
