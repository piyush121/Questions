/* https://leetcode.com/problems/partition-list/ */

public class PartitionList
{
	//collect all the numbers greater than x and append them at the end of the list
	public ListNode partition(ListNode head, int x)
    {
    	if(head==null || head.next == null)
    		return head;

    	ListNode l1 = new ListNode(0);
    	l1.next = head;
    	ListNode p1 = l1;
    	//contains all the number greater than or equal to x
    	ListNode l2 = new ListNode(0);
    	ListNode p2 = l2;

    	while(p1.next!=null)
    	{
    		System.out.println("val: " + p1.next.val);
    		if(p1.next.val >= x)
    		{
    			p2.next = p1.next;
    			p1.next = p1.next.next;
    			p2 = p2.next;
    		}
    		else
    		{
    			p1 = p1.next;
    		}
    	}
    	p2.next = null;
    	p1.next = l2.next;
    	return l1.next;
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
		PartitionList p = new PartitionList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		System.out.println("before: "); 
		p.printList(head);
		head = p.partition(head, 3);
		System.out.println("after: ");
		p.printList(head);
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