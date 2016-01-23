/* https://leetcode.com/problems/remove-duplicate-letters/ */
class RemoveDuplicateLetters
{
	public String removeDuplicateLetters(String s) 
	{
        char[] alpha = new char[26];
        for(int i=0;i<s.length();i++)
        {
        	alpha[s.charAt(i)-'a'] = s.charAt(i);
        }
        String result = "";
        for(int i=0;i<26;i++)
        {
        	if(alpha[i]!='\0')
        		result = result + alpha[i];
        }
        return result;
    }

    public static void main(String[] args)
    {
    	RemoveDuplicateLetters r = new RemoveDuplicateLetters();
    	String s = "bcabc";
    	System.out.println(r.removeDuplicateLetters(s));
    }
}