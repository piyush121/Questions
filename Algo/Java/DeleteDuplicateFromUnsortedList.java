/* http://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/ */

//the idea is to use hashset, loop through each node and check whether 
//the node is already present in the hashset or not 
//if present then delete the node from hashset 
//otherwise add it to hashset

import java.util.HashSet;
import java.util.Set;
public class DeleteDuplicateFromUnsortedList
{
	public void deleteDuplicates(ListNode head)
	{
		if(head == null || head.next == null)
			return;
		Set<Integer> set = new HashSet<Integer>();
		ListNode p = head;
		while(p != null)
		{
			printLinkedList(head);
			if(!set.contains(p.val))
			{
				set.add(p.val);
				p = p.next;
			}
			else
			{
				ListNode p2 = head;
				while(p2.next!=p)
					p2 = p2.next;

				p2.next = p.next;
				p = p2.next;
			}
		}
	}

	public static void main(String args[])
	{
		//12->11->12->21->41->43->21
		ListNode head = new ListNode(12);
		head.next = new ListNode(11);
		head.next.next = new ListNode(12);
		head.next.next.next = new ListNode(21);
		head.next.next.next.next = new ListNode(41);
		head.next.next.next.next.next = new ListNode(43);
		head.next.next.next.next.next.next = new ListNode(21);

		DeleteDuplicateFromUnsortedList d = new DeleteDuplicateFromUnsortedList();
		d.deleteDuplicates(head);
		d.printLinkedList(head);
	}

	public void printLinkedList(ListNode head)
	{
		ListNode p = head;
		while(p!=null)
		{
			System.out.print(p.val + "\t");
			p = p.next;
		}
		System.out.println();
	}
}

class ListNode
{
	int val;
	ListNode next;
	ListNode(int val)
	{
		this.val = val;
	}
}