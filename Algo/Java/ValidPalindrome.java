import java.util.*;
class ValidPalindrome
{
	public static void main(String args[])
	{
		String str = "A man, a plan, a canal: Panama";
		ValidPalindrome vp = new ValidPalindrome();
		//System.out.println(vp.method1(str));
		System.out.println(vp.method2(str));
	}

	public boolean method1(String str)
	{
		str = str.replaceAll("[^0-9A-z]", "").toLowerCase();
		System.out.println(str);
		if(str.length()<2)
			return true;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!=str.charAt(str.length()-1-i))
			{
				return false;
			}
		}
		return true;
	}

	public boolean method2(String str)
	{
		str = str.replaceAll("[^0-9A-z]", "").toLowerCase();
		System.out.println(str.length());
		if(str.length()<2)
			return true;
		Stack<Character> stack = new Stack<Character>();
		int index =0;
		while(index < str.length()/2)
		{
			stack.push(str.charAt(index));
			index++;
		}
		if(str.length()%2==1)
		{
			index++;
		}
		System.out.println(index);
		for(int i = index;i<str.length();i++)
		{
			if(stack.pop()!=str.charAt(i))
			{
				return false;
			}
		}
		return true;
	}
}
