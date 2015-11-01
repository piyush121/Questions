import java.util.*;
class Skyline
{
	public int solution(int h[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		int block=0;
		for(int i:h)
		{
			while(!stack.isEmpty() && i<stack.peek())
			{
				stack.pop();
			}
			if(stack.isEmpty() || stack.peek() < i)
			{
				System.out.println(i);
				stack.push(i);
				block++;
			}
		}
		return block;
	}

	public static void main(String args[])
	{
		Skyline skyline = new Skyline();
		int[] h = {8,8, 5, 7, 9, 8, 7, 4, 8};
		System.out.println(skyline.solution(h));
	}
}
