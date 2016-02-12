/* https://leetcode.com/problems/valid-anagram/ */

/* to check if the given string is the valid anagram of another given string*/
public class ValidAnagram
{
    public boolean isAnagram(String s, String t)
    {
        //create an array with length equal to 256
        int[] array = new int[256];
        //if s is null or t is null
        //then return false
        if(s==null || t==null)
            return false;
        //if the length of s is not equal to t
        //then return false
        if(s.length()!=t.length())
            return false;
        //loop through the String s and t and for every character encountered 
        //in s increment its corresponding value in the array
        //for every character encountered in t decrement its corresponding
        //value in the array
        for(int i=0;i<s.length();i++)
        {
            array[s.charAt(i)]++;
            array[t.charAt(i)]--;
        }
        //Now check if the all the values in array are 0 then the two given 
        //strings are valid anagram otherwise not
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
