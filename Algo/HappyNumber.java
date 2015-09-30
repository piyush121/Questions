public class HappyNumber
{
    public static void main(String args[])
    {
        HappyNumber h = new HappyNumber();
        System.out.println(h.calculateSumOfSquares(19));
    }

    public boolean isHappy(int num)
    {
        if(num==1)
            return true;
        else if(num==4 || num==0)
            return false;
        else
            return isHappy(calculateSumOfSquares(num));
    }

    public int calculateSumOfSquares(int num)
    {
        int sum = 0;
        while(num!=0)
        {
            int temp = num%10;
            sum = sum + temp*temp;
            num = num/10;
        }
        return sum;
    }
}
