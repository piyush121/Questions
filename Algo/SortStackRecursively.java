/* http://www.geeksforgeeks.org/sort-a-stack-using-recursion/ */

import java.util.Stack;
class SortStackRecursively
{
	public static void main(String args[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-3);
		stack.push(2);
		stack.push(5);
		stack.push(8);
		stack.push(3);
		stack.push(0);
		SortStackRecursively s = new SortStackRecursively();
		s.sort(stack, 0);
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}

	public void sort(Stack<Integer> stack, Integer temp)
	{
		if(!stack.isEmpty())
		{
			temp = stack.pop(); // pop stack recursively until it is empty
			sort(stack, temp);
			if(stack.isEmpty()) //if the stack is empty then push element
				stack.push(temp);
			else if(stack.peek() > temp) //if top is greater than temp pop it
			{
				int top = stack.pop();
				stack.push(temp); //push temp
				sort(stack, temp); // move temp to its sorted position
				stack.push(top); // push top
			}
			else
				stack.push(temp);
		}
	}
}