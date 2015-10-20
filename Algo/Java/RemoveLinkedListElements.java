public class RemoveLinkedListElements
{
    public static void main(String args[])
    {
        RemoveLinkedListElements r = new RemoveLinkedListElements();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head = r.removeElements(head, 6);
        r.printLinkedList(head);
    }

    public ListNode removeElements(ListNode head, int val)
    {
        while(head!=null && head.val==val)
            head = head.next;
        if(head == null)
            return head;
        ListNode p1 = head.next;
        while(p1!=null)
        {
            if(p1.val == val)
            {
                ListNode p2 = head;
                while(p2.next!=p1)
                    p2 = p2.next;
                p2.next = p1.next;
                p1 = p2;
            }
            p1 = p1.next;
        }
        return head;
    }

    public void printLinkedList(ListNode head)
    {
        ListNode p1 = head;
        while(p1!=null)
        {
            System.out.print(p1.val + "\t");
            p1 = p1.next;
        }
        System.out.println();
    }
}

class ListNode
{
    ListNode next;
    int val;

    ListNode(int x)
    {
        this.val = x;
    }
}
