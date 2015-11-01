import java.util.*;
class QueueStack<E>
{
	private Stack<E> inStack = new Stack<E>();
	private Stack<E> outStack = new Stack<E>();

	public void insert(E item)
	{
		inStack.push(item);
	}

	public E remove()
	{
		if(outStack.isEmpty())
		{
			while(!inStack.isEmpty())
			{
				outStack.push(inStack.pop());
			}
		}
		return outStack.pop();
	}

	public static void main(String args[])
	{
		QueueStack<Integer> q = new QueueStack<Integer>();
		q.insert(1);
		q.insert(2);
		q.insert(3);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}
}
