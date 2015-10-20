import java.util.HashMap;
public class RomanToInteger
{
    public static void main(String arg[])
    {
        RomanToInteger r = new RomanToInteger();
        System.out.println(r.romanToInt("IV"));
        System.out.println(r.romanToInt("XI"));
        System.out.println(r.romanToInt("XXIV"));
        System.out.println(r.romanToInt("XCIX"));
    }

    public int romanToInt(String s)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int prev = 0;
        int sum = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            int num = map.get(s.charAt(i));
            if(num>=prev)
                sum = sum + num;
            else
                sum = sum - num;
            prev = num;
        }
        return sum;
    }
}
