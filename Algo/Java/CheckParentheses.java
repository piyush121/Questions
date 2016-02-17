/* http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/ */
import java.util.Stack;
import java.util.HashMap;
class CheckParentheses
{
	//map to store opening and closing parentheses as key/value pair 
	HashMap<Character, Character> map = null;
	//stack to hold parentheses
	Stack<Character> stack = null;
	//Initialize the map
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
		//if the string s is null or empty 
		//return true (parentheses already balanced)
		if(s==null || s.equals(""))
			return true;
		//loop through string
		for(int i=0;i<s.length();i++)
		{
			//if any key in the map matches the character at index i in string
			//then push the character on the stack
			if(map.containsKey(s.charAt(i)))
			{
				stack.push(s.charAt(i));
			}
			//if the stack is not empty and the character at index i in string
			//is equals to any value in map
			//then pop the stack
			else if(!stack.isEmpty() && map.get(stack.peek())==s.charAt(i))
			{
				stack.pop();
			}
			else
			{
				return false;
			}
		}
		//if the stack is empty after processing te string
		//then valid parentheses else return false
		return stack.isEmpty();
	}

	public static void main(String args[])
	{
		CheckParentheses cp = new CheckParentheses();
		String s = "]";
		System.out.println(cp.isValid(s));
	}
}
