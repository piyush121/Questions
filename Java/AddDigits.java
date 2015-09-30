/* https://leetcode.com/problems/add-digits/ */

class AddDigits
{
    public int addDigits(int num)
    {
        if(num<10)
            return num;
        else
        {
            return num%9==0?9:num%9;
        }
    }

    public static void main(String args[])
    {
        AddDigits a = new AddDigits();
        System.out.println(a.addDigits(13));
    }
}
