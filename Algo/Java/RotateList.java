/* https://leetcode.com/problems/rotate-list/ */

public class RotateList
{
	public ListNode rotateRight(ListNode head, int k) 
	{
		if(head==null)
			return null;
        ListNode p1 = head;
        ListNode p2 = head;
        int i=0;
        int length = 0;
        while(p2!=null)
        {
        	p2= p2.next;
        	length++;
        }
        if(length==1)
        	return head;
        p2 = head;
        while(p2.next!=null && i<(k%length))
        {
        	p2=p2.next;
        	i++;
        }
        while(p2.next!=null)
        {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        p2.next = head;
        head = p1.next;
        p1.next = null;
        return head;
    }

    public void printList(ListNode head)
    {
    	ListNode p = head;
    	while(p!=null)
    	{
    		System.out.print(p.val+" ");
    		p = p.next;
    	}
    	System.out.println();
    }

	public static void main(String args[])
	{
		ListNode head = new ListNode(1);
		//head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		RotateList r = new RotateList();
		r.printList(head);
		head = r.rotateRight(head, 4);
		r.printList(head);
	}
}

class ListNode 
{
     int val;
     ListNode next;
     ListNode(int x) 
     { 
     	val = x; 
     }
 }