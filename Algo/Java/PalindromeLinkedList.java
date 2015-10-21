public class PalindromeLinkedList
{
    public static void main(String[] args)
    {
        PalindromeLinkedList p = new PalindromeLinkedList();
        Node node = new Node(1);
        node.next = new Node(0);
        node.next.next = new Node(1);
        //node.next.next.next = new Node(0);
        p.printList(node);
        //Node reverseHead = p.reverseList(node);
        //p.printList(reverseHead);
        //Node reverseList = p.createReverseList(node);
        //p.printList(reverseList);
        System.out.println(p.isPalindrome(node));
    }

    public boolean isPalindrome(Node head)
    {
        Node reverseHead = createReverseList(head);
        Node p1 = head;
        while(p1!=null)
        {
            if(p1.val != reverseHead.val)
                return false;
            p1 = p1.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    public Node reverseList(Node head)
    {
        Node p1 = null;
        Node p2 = head;
        Node p3 = head.next;
        while(p2.next!=null)
        {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }

    public Node createReverseList(Node head)
    {
        Node p1 = null;
        Node p2 = null;
        Node p3 = head;

        while(p3!=null)
        {
            p2 = new Node(p3.val);
            p2.next = p1;
            p1 = p2;
            p3 = p3.next;
        }
        return p2;
    }

    public void printList(Node head)
    {
        Node p1 = head;
        while(p1!=null)
        {
            System.out.print(p1.val+"\t");
            p1 = p1.next;
        }
        System.out.println();
    }
}

class Node
{
    int val;
    Node next;

    Node(int x)
    {
        val = x;
        next = null;
    }
}
