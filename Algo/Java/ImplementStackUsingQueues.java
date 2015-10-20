/* https://leetcode.com/problems/implement-stack-using-queues/ */
import java.util.LinkedList;
public class ImplementStackUsingQueues
{
    LinkedList<Integer> primary = new LinkedList<Integer>();
    int top = -1;
    // Push element x onto stack.
   public void push(int x)
   {
       primary.add(x);
       top = x;
   }

   // Removes the element on top of the stack.
   public void pop()
   {
       LinkedList<Integer> temp = new LinkedList<Integer>();
       int num = -1;
       while(!primary.isEmpty())
       {
           top = num;
           num = primary.remove();
           if(top != -1)
           {
               temp.add(top);
           }
       }
       primary = temp;
       if(empty())
       {
           top = -1;
       }
       temp = null;
   }

   // Get the top element.
   public int top()
   {
       return top;
   }

   // Return whether the stack is empty.
   public boolean empty()
   {
       if(primary.isEmpty())
       {
           return true;
       }
       return false;
   }

   public static void main(String args[])
   {
       ImplementStackUsingQueues i = new ImplementStackUsingQueues();
       i.push(2);
       i.push(3);
       System.out.println(i.primary);
       i.pop();
       System.out.println(i.primary);
       System.out.println(i.top);
       i.push(5);
       i.push(6);
       System.out.println(i.primary);
       System.out.println(i.top);
       i.pop();
       System.out.println(i.primary);
       i.pop();
       System.out.println(i.primary);
       i.pop();
       System.out.println(i.primary);
       i.pop();
   }
}
