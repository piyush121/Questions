/* https://leetcode.com/problems/valid-anagram/ */

/* to check if the given string is the valid anagram of other string*/
public class ValidAnagram
{
    public boolean isAnagram(String s, String t)
    {
        int[] array = new int[256];
        if(s==null || t==null)
            return false;
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++)
        {
            array[s.charAt(i)]++;
            array[t.charAt(i)]--;
        }
        for(int i=0;i<array.length;i++)
        {
            if(array[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        ValidAnagram v = new ValidAnagram();
        String s = "rat";
        String t = "car";

        System.out.println(v.isAnagram(s,t));
    }
}
