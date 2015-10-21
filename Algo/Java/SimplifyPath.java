import java.util.Stack;
class SimplifyPath
{
	public String simplifyPath(String path)
	{
		if(path.length()==1 && path.equals("/"))
			return path;

		Stack<String> stack = new Stack<String>();
		stack.push("/");
		String[] tokens = path.split("/");
		for(String token: tokens)
		{
			if(token==null || token.equals("") || token.equals("."))
				continue;
			else if(token.equals("..") && !stack.isEmpty())
			{
				stack.pop();
			}
			else if(!token.equals("..") && !token.equals("."))
			{
				stack.push(token);
			}
		}
		System.out.println(stack);
		String s = "";
		while(!stack.isEmpty())
		{
			if(!stack.peek().equals("/"))
				s = "/"+stack.pop()+s;
			else
				break;
		}
		System.out.println(s);
		printArray(tokens);
		if(s==null ||s.equals("") || s.charAt(0)!='/')
			s = "/"+s;
		return s;
    }

	public void printArray(String[] a)
	{
		System.out.println("length: "+a.length);
		for(String s:a)
			System.out.print(s+" ");
	}

	public static void main(String args[])
	{
		//String path = "/home/";
		//String path = "/a/./b/../../c/";
		//String path = "/...";
		String path = "/home/../../..";
		//String path = "/home//foo/";
		SimplifyPath s = new SimplifyPath();
		s.simplifyPath(path);
	}
}
