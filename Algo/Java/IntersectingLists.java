import java.util.HashSet;
public class IntersectingLists
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode a = headA;
		ListNode b = headB;
		while(a!=null)
		{
			set.add(a);
			a = a.next;
		}
		while(b!=null)
		{
			if(set.contains(b))
				return b;
			b = b.next;
		}
		return null;
	}
}

/*
	Method 2
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if(headA == null)   return headA;

    if(headB == null)   return headB;

    while(headA!=null && headB!=null){

        if(headA.val == headB.val)
            return headA;

        if(headA.val<headB.val)
            headA=headA.next;
        else
            headB=headB.next;

    }

    return null;

}
*/

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
