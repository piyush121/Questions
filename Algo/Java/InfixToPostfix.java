import java.util.Stack;
import java.util.HashMap;
class InfixToPostfix
{
	HashMap<String, Integer> precedenceMap;
	Stack<String> opStack;
	public InfixToPostfix()
	{
		precedenceMap = new HashMap<String, Integer>();
		precedenceMap.put("*", 2);
		precedenceMap.put("/", 2);
		precedenceMap.put("+", 1);
		precedenceMap.put("-", 1);
		opStack = new Stack<String>();

	}

	public String infixToPostFix(String exp)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<exp.length();i++)
		{
			if(precedenceMap.containsKey(exp.charAt(i)+""))
			{
				if(opStack.isEmpty())
					opStack.push(exp.charAt(i)+"");
				else
				{
					while(!opStack.isEmpty() && precedenceMap.get(opStack.peek())>precedenceMap.get(exp.charAt(i)+""))
					{
						sb.append(opStack.pop());
					}
					opStack.push(exp.charAt(i)+"");
				}
			}
			else
			{
				sb.append(exp.charAt(i));
			}
			System.out.println(opStack);
		}
		while(!opStack.isEmpty())
			sb.append(opStack.pop());
		return sb.toString();
	}

	public static void main(String args[])
	{
		InfixToPostfix i = new InfixToPostfix();
		System.out.println(i.infixToPostFix("3+1*4/7"));
	}
}
