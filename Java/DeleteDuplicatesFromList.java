public class DeleteDuplicatesFromList
{
	public ListNode deleteDuplicates(ListNode head) 
	{
        if(head==null || head.next==null)
			return head;
		int prev = head.val;
		ListNode p1 = head.next;
		while(p1!=null)
		{
			if(prev == p1.val)
			{
				ListNode p2 = head;
				while(p2.next!= p1)
					p2= p2.next;
				prev = p1.val;
				p1 = p1.next;
				p2.next = p1;
			}
			else
			{
				prev = p1.val;
				p1 = p1.next;
			}
		}
		return head;
    }
	
	public void printLinkedList(ListNode head)
	{
		ListNode node = head;
		while(node!=null)
		{
			System.out.print(node.val+"\t");
			node = node.next;
		}
	}
	
	public static void main(String args[])
	{
		DeleteDuplicatesFromList d = new DeleteDuplicatesFromList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head = d.deleteDuplicates(head);
		d.printLinkedList(head);
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