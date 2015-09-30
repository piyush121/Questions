/* https://leetcode.com/problems/count-and-say/ */
public class CountAndSay
{
    public String countAndSay(int n)
    {
        if(n<0)
            return "";
        else if(n==0)
            return "";
        else if(n==1)
            return "1";
        else
        {
            String result = ""+n;
            int temp=n;
            for(int i=1;i<n;i++)
            {
                String num = this.createString(this.getCountArray(temp));
                result += ", " + num;
                temp = Integer.parseInt(num);
            }
            return result;
        }
    }

    private int[] getCountArray(int n)
    {
        int[] countArray = new int[10];
        while(n!=0)
        {
            countArray[n%10]++;
            n = n/10;
        }
        return countArray;
    }

    private String createString(int[] countArray)
    {
        String num = "";
        for(int i=0;i<10;i++)
        {
            if(countArray[i]>0)
                num += countArray[i]+""+i;
        }
        return num;
    }

    public static void main(String args[])
    {
        CountAndSay solution = new CountAndSay();
        System.out.println(solution.countAndSay(4));
    }

}
