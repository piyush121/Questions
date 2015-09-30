import java.util.Map;
import java.util.HashMap;
public class IsomorphicStrings
{
    public static void main(String args[])
    {
        IsomorphicStrings i = new IsomorphicStrings();
        System.out.println(i.isIsomorphic("egg","add"));
        System.out.println(i.isIsomorphic("foo", "bar"));
        System.out.println(i.isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t)
    {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                if(!set.contains(t.charAt(i)))
                {
                    map.put(s.charAt(i), t.charAt(i));
                    set.add(t.charAt(i));
                }
                else
                {
                    return false;
                }
            }
            else
            {
                char c = map.get(s.charAt(i));
                if(c!=t.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
