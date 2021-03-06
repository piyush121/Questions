/* https://leetcode.com/problems/copy-list-with-random-pointer/ */
import java.util.HashMap;
public class CopyListWithRandomPointers
{
	public RandomListNode copyRandomList(RandomListNode head) 
	{
		if(head == null)
			return null;
		RandomListNode p = head;
        HashMap<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode node = new RandomListNode(p.label);
        map.put(p.label, node);
        while(p!=null)
        {
        	System.out.println("p : " + p.label);
        	if(p.next!=null)
        	{
        		//System.out.println("p.next : " + p.next.label);
        		if(!map.containsKey(p.next.label))
        		{
        			map.put(p.next.label, new RandomListNode(p.next.label));
        		}
        		node.next = map.get(p.next.label);
        	}
        	if(p.random!=null)
        	{
        		//System.out.println("p.random : " + p.random.label);
        		if(!map.containsKey(p.random.label))
        		{
        			map.put(p.random.label, new RandomListNode(p.random.label));
        		}
        		node.random = map.get(p.random.label);
        	}
        	p = p.next;
        	node = node.next;
        }
        return map.get(head.label);
    }

    public void print(RandomListNode head)
    {
    	RandomListNode p = head;
    	while(p!=null)
    	{
    		System.out.print(p.label+"\t");
    		p = p.next;
    	}
    	System.out.println();
    }

	public static void main(String args[])
	{
		CopyListWithRandomPointers c = new CopyListWithRandomPointers();
		RandomListNode r = new RandomListNode(1);
		r.next = new RandomListNode(2);
		r.next.next = new RandomListNode(3);
		r.next.next.next = new RandomListNode(4);
		r.next.next.next.next = new RandomListNode(5);

		r.random = r.next.next;
		r.next.next.random = r.next;
		c.print(r);
		RandomListNode copyListHead = c.copyRandomList(r);
		c.print(copyListHead);
	}
}

class RandomListNode 
{
    int label;
    RandomListNode next, random;
    RandomListNode(int x) 
    { 
    	this.label = x; 
    }
 }