/* https://leetcode.com/problems/implement-queue-using-stacks/ */
import java.util.Stack;
public class ImplementQueueUsingStacks
{
    Stack<Integer> primary = new Stack<Integer>();
    Stack<Integer> auxiliary = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x)
    {
       primary.push(x);
    }

    // Removes the element from in front of queue.
    public void pop()
    {
       if(auxiliary.isEmpty())
       {
           while(!primary.isEmpty())
           {
               auxiliary.push(primary.pop());
           }
       }
       if(!auxiliary.isEmpty())
       {
           auxiliary.pop();
       }
    }

    // Get the front element.
    public int peek()
    {
        if(auxiliary.isEmpty())
        {
            while(!primary.isEmpty())
            {
                auxiliary.push(primary.pop());
            }
        }
        if(!auxiliary.isEmpty())
        {
            return auxiliary.peek();
        }
        return -1;
    }

    // Return whether the queue is empty.
    public boolean empty()
    {
         if(primary.isEmpty() && auxiliary.isEmpty())
         {
             return true;
         }
         return false;
    }

    public static void main(String args[])
    {
        ImplementQueueUsingStacks i = new ImplementQueueUsingStacks();
        i.push(1);
        i.push(2);
        System.out.println(i.peek());
        i.push(3);
        System.out.println(i.peek());
        i.pop();
        System.out.println(i.peek());
    }
}
