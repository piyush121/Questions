/* https://leetcode.com/problems/string-to-integer-atoi/ */
class StringToInteger
{
    //if number is negative
    //if number is larger than integer range
    public int myAtoi(String str)
    {
        if(str==null || "".equals(str))
            return 0;
        long temp = 0;
        char sign = '';
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='0' && str.charAt(i) <='9')
            {
                temp = temp * 10 + (int)(str.charAt(i)-'0');
                if(temp > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if(temp < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            else if(str.charAt(i)==' ')
                continue;
            else if(str.charAt(i)== '+' || str.charAt(i)=='-')
            {
                if(sign=='')
                    sign = str.charAt(i);
                else
                    return 0;
            }
            else
                return 0;
        }
        if(sign=='-')
            temp*=-1;
        return (int)temp;
    }


    public static void main(String args[])
    {
        StringToInteger solution = new StringToInteger();
        System.out.println(solution.myAtoi("+-1"));
    }
}
