
import java.util.Stack;
class SortStack
{
	private static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String args[])
	{
		stack.push(10);
		stack.push(70);
		stack.push(20);
		stack.push(40);
		stack.push(30);
		System.out.println(stack);
		sortStack();
	}

	public static void sortStack()
	{
		Stack<Integer> tempStack = new Stack<Integer>();
		while(!stack.isEmpty())
		{
			System.out.println("tempStack:"+tempStack);
			System.out.println("stack:"+stack);
			int temp = stack.pop();
			while(!tempStack.isEmpty() && tempStack.peek()<temp)
			{
				stack.push(tempStack.pop());
			}
			tempStack.push(temp);
		}
		System.out.println(tempStack);
	}
}
