/* http://geeksquiz.com/stack-set-4-evaluation-postfix-expression/ */

import java.util.Stack;


public class PostfixExpressionEvaluation
{
	public int evaluate(String[] expression)
	{
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<expression.length;i++)
		{
			String symbol = expression[i]+"";
			if(isNumber(expression[i]+""))
				stack.push(Integer.parseInt(symbol));
			else
				helperEvaluate(symbol, stack);
		}
		return stack.pop();
	}

	public void helperEvaluate(String symbol, Stack<Integer> stack)
	{
		int b = stack.pop();
		int a = stack.pop();
		switch(symbol)
		{
			case "+" : stack.push(a + b); break;
			case "-" : stack.push(a - b); break;
			case "*" : stack.push(a * b); break;
			case "/" : stack.push(a / b); break;
 		}
	}

	public boolean isNumber(String symbol)
	{
		boolean flag = true;
		try
		{
			Integer.parseInt(symbol);
		}
		catch(NumberFormatException ne)
		{
			flag = false;
		}
		return flag;
	}
	
	public static void main(String args[])
	{
		String exp  = "2 3 1 * + 9 -";
		String[] expression = exp.split(" ");
		PostfixExpressionEvaluation p = new PostfixExpressionEvaluation();
		System.out.println(p.evaluate(expression));
	}
}