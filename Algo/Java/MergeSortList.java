public class MergeSortList
{
	public ListNode divide(ListNode head)
	{
		if(head==null || head.next==null)
			return head;

		ListNode l = head;
		ListNode r = head;
		ListNode prev = null;
		ListNode q = head.next;
		while(q!=null)
		{
			if(q.next!=null)
			{
				q=q.next.next;
			}
			else
			{
				q=q.next;
			}
			prev = r;
			r = r.next;
		}
		prev.next = null;
		System.out.println("left: "+l.val+" `right: "+r.val+"prev: "+prev.val);
		ListNode h1 = divide(l);
		ListNode h2 = divide(r);
		return merge(h1,h2);
	}

	public ListNode merge(ListNode l, ListNode r)
	{
		ListNode p1 = l;
		ListNode p2 = r;

		ListNode newList = new ListNode(Integer.MAX_VALUE);
		ListNode fakeHead = newList;

		while(p1!=null || p2!=null)
		{
			if(p1==null)
			{
				newList.next = new ListNode(p2.val);
				p2 = p2.next;
				newList = newList.next;
			}
			else if(p2==null)
			{
				newList.next = new ListNode(p1.val);
				p1 = p1.next;
				newList = newList.next;
			}
			else if(p1.val<p2.val)
			{
				newList.next = new ListNode(p1.val);
				p1 = p1.next;
				newList = newList.next;
			}
			else if(p1.val == p2.val)
			{
				newList.next = new ListNode(p1.val);
				newList.next.next = new ListNode(p1.val);
				newList = newList.next.next;
				p1 = p1.next;
				p2 = p2.next;
			}
			else
			{
				newList.next = new ListNode(p2.val);
				p2 = p2.next;
				newList = newList.next;
			}
		}
		return fakeHead.next;
	}

	public static void main(String args[])
	{
		MergeSortList m = new MergeSortList();
		//1->7->3->5->2
		ListNode node = new ListNode(1);
		node.next = new ListNode(7);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(5);
		node.next.next.next.next = new ListNode(2);

		ListNode head = m.divide(node);
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}

class ListNode
{
	ListNode next;
	int val;

	public ListNode(int val)
	{
		this.val = val;
		this.next = null;
	}
}
