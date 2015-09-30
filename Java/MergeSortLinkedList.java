public class MergeSortLinkedList
{
	public LinkNode sort(LinkNode head)
	{
		return helperDivide(head);
	}
	
	public LinkNode helperDivide(LinkNode head)
	{
		if(head == null || head.next==null)
		{
			return head;
		}
		LinkNode p = head;
		LinkNode q = head;
		LinkNode r=null;
		while(q!=null)
		{
			if(q.next!=null)
			{
				q = q.next.next;
			}
			else
			{
				q = q.next;
			}
			r = p;
			p = p.next;	
		}
		r.next = null;
		LinkNode left = helperDivide(head);
		LinkNode right = helperDivide(p);
		return helperMerge(left, right);
	}
	
	public LinkNode helperMerge(LinkNode a, LinkNode b)
	{
		LinkNode p = a;
		LinkNode q = b;
		LinkNode newList = new LinkNode(Integer.MIN_VALUE);
		LinkNode head = newList;
		while(p!=null || q!=null)
		{
			if(p==null)
			{
				newList.next = new LinkNode(q.val);
				newList = newList.next;
				q = q.next;
			}
			else if(q==null)
			{
				newList.next = new LinkNode(p.val);
				newList = newList.next;
				p = p.next;
			}
			else if(p.val < q.val)
			{
				newList.next = new LinkNode(p.val);
				newList = newList.next;
				p = p.next;
			}
			else if(q.val < p.val)
			{
				newList.next = new LinkNode(q.val);
				newList = newList.next;
				q = q.next;
			}
			else if(p.val == q.val)
			{
				newList.next = new LinkNode(p.val);
				newList.next.next = new LinkNode(q.val);
				newList = newList.next.next;
				p = p.next;
				q = q.next;
			}
		}
		return head.next;
	}
	
	public LinkNode removeDuplicates(LinkNode head)
	{
		if(head==null || head.next==null)
			return head;
		LinkNode prev  = null;
		LinkNode curr = head;
		while(curr!=null)
		{
			if(prev!=null)
			{
				
				if(curr.val==prev.val)
				{
					curr = curr.next;
					prev.next = curr;
					//System.out.println(prev.val+" "+curr.val);
				}
				else
				{
					prev = curr;
					curr = curr.next;
				}
			}
			else
			{
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
	
	public static void main(String args[])
	{
		MergeSortLinkedList m = new MergeSortLinkedList();
		LinkNode head = new LinkNode(3);
		head.next = new LinkNode(2);
		head.next.next = new LinkNode(1);
		head.next.next.next = new LinkNode(2);
		head = m.sort(head);
		head = m.removeDuplicates(head);
		LinkNode p = head;
		while(p!=null)
		{
			System.out.print(p.val+" ");
			p = p.next;
		}
	}
}

class LinkNode
{
	LinkNode next;
	int val;
	LinkNode(int val)
	{
		this.val = val;
	}
}