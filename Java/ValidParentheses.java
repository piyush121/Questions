import java.util.*;
class ValidParentheses
{
	public static void main(String args[])
	{
		ValidParentheses vp = new ValidParentheses();
		String check1 = "[{]}";
		String check2 = "[{()}]";
		System.out.println(vp.checkParentheses(check1));
		System.out.println(vp.checkParentheses(check2));
 	}
	
	public boolean checkParentheses(String checkStr)
	{
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('{','}');
		map.put('(',')');
		map.put('[',']');
		char[] arr = checkStr.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{	
				stack.push(arr[i]);
			}
			else
			{
				if(!stack.isEmpty() && (map.get(stack.peek())==arr[i]))
				{
					stack.pop();
				}
				else
				{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}