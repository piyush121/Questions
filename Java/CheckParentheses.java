import java.util.Stack;
import java.util.HashMap;
class CheckParentheses
{
	HashMap<Character, Character> map = null;
	Stack<Character> stack = null;
	public CheckParentheses()
	{
		map = new HashMap<Character, Character>();
		map.put('(',')');
		map.put('{','}');
		map.put('[',']');
		stack = new Stack<Character>();
	}
	
	public boolean isValid(String s)
	{
		if(s==null || s.equals(""))
			return true;
		for(int i=0;i<s.length();i++)
		{
			if(map.containsKey(s.charAt(i)))
			{
				stack.push(s.charAt(i));
			}
			else if(!stack.isEmpty() && map.get(stack.peek())==s.charAt(i))
			{
				stack.pop();
			}
			else
			{
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String args[])
	{
		CheckParentheses cp = new CheckParentheses();
		String s = "]";
		System.out.println(cp.isValid(s));
	}
}