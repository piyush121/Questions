public class DeleteNodeInALinkedList
{
    public static void main(String args[])
    {
        DeleteNodeInALinkedList d = new DeleteNodeInALinkedList();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        //listNode.next.next = new ListNode(3);
        //listNode.next.next.next = new ListNode(4);
        d.deleteNode(listNode);
        while(listNode!=null)
        {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public void deleteNode(ListNode node)
    {
        //System.out.println("p1: "+node.val);
        ListNode p1 = node;
        ListNode p2 = node.next;
        //System.out.println("p2: "+ p2.val);
        while(p2.next!=null)
        {
            p1.val = p2.val;
            p1 = p2;
            p2 = p2.next;
        }
        p1.val = p2.val;
        p1.next = null;
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
