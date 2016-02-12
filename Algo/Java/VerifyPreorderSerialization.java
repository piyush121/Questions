/* https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/ */
import java.util.Stack;
public class VerifyPreorderSerialization
{
	public boolean isValidSerialization(String preorder) 
	{
		Stack<String> stack = new Stack<String>();
        String[] s = preorder.split(",");
        if(s.length==0)
        {
        	return false;
        }
        if(s.length==1)
        {
            if(s[0].equals("#"))
                return true;
            else
                return false;
        }
        stack.push(s[0]);
        for(int i=1;i<s.length;i++)
        {
        	if(!s[i].equals("#"))
        	{
        		stack.push(s[i]);
        	}
        	else if(s[i].equals("#"))
        	{
        		if(!"#".equals(stack.peek()))
        		{
        			stack.push(s[i]);
        		}
        		else
        		{
        			if(!pushPoundSymbol(stack, s[i]))
        				return false;
        		}
        	}
        }
        if(stack.size()==1 && "#".equals(stack.peek()))
        	return true;
        else
        	return false;
    }

    public boolean pushPoundSymbol(Stack<String> stack, String symbol)
    {
    	if(stack.isEmpty() || !"#".equals(stack.peek()))
    	{
    		stack.push(symbol);
    	}
    	else
    	{
    		if(stack.size()>1)
    		{
    			stack.pop();
    			if(!"#".equals(stack.peek()))
    				stack.pop();
    			else
    				return false;
    			return pushPoundSymbol(stack, "#");
    		}
    		else
    			return false;
    	}
    	return true;
    }

    public static void main(String args[])
    {
    	VerifyPreorderSerialization v = new VerifyPreorderSerialization();
    	//String serializedString = "9,3,4,#,#,1,#,#,2,#,6,#,#";
    	String serializedString = "4,#,#,1";
    	System.out.println(v.isValidSerialization(serializedString));
    }
}