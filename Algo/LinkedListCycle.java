public class LinkedListCycle
{
	public boolean hasCycle(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return false;
        }
        ListNode a = head;
		ListNode b = null;
        if(head.next!=null)
			b = head.next.next;
		else
			return false;
        while(a!=b && b!=null)
        {
            a = a.next;
            if(b.next!=null)
                b = b.next.next;
			else 
				return false;
        }
		if(b==null)
			return false;
		else
			return true;
    }
	
	public static void main(String args[])
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = head;
		LinkedListCycle llc = new LinkedListCycle();
		System.out.println(llc.hasCycle(head));
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