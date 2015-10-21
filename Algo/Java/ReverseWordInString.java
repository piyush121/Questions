import java.util.Stack;
class ReverseWordInString
{
	public String reverseWords(String s)
    {
        Stack<String> stack = new Stack<String>();
        String[] tokens = s.split("\\s+");
		//System.out.println(tokens.length);
        for(String token: tokens)
        {
            stack.push(token);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pop().trim()).append(" ");
        }
        return sb.toString().trim();
    }

	public static void main(String args[])
	{
		String str = "   a   b ";
		ReverseWordInString r = new ReverseWordInString();
		System.out.println(r.reverseWords(str));
	}
}
