import java.util.Stack;
class EvaluateReversePolish
{
	public int evalRPN(String[] tokens)
	{
		Stack<String> stack = new Stack<String>();
		String map ="+-*/";
		for(int i=0;i<tokens.length;i++)
		{
			if(map.contains(tokens[i]))
			{
				String b = stack.pop();
				String a = stack.pop();
				stack.push(evaluate(tokens[i], a, b));
			}
			else
			{
				stack.push(tokens[i]);
			}
		}
		return Integer.parseInt(stack.pop());
	}

	public String evaluate(String op, String a, String b)
	{
		switch(op)
		{
			case "+": return Integer.parseInt(a) + Integer.parseInt(b)+"";
			case "-": return Integer.parseInt(a) - Integer.parseInt(b)+"";
			case "*": return Integer.parseInt(a) * Integer.parseInt(b)+"";
			case "/": return Integer.parseInt(a) / Integer.parseInt(b)+"";
		}
		return null;
	}

	public static void main(String[] args)
	{
		EvaluateReversePolish erp = new EvaluateReversePolish();
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(erp.evalRPN(tokens));
	}
}
