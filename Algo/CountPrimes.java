import java.util.ArrayList;
public class CountPrimes
{
    public static void main(String args[])
    {
        CountPrimes cp = new CountPrimes();
        long startTime = System.currentTimeMillis();
        System.out.println(cp.countPrimes(79190000));
        System.out.println(System.currentTimeMillis()-startTime);
    }

    public int countPrimes(int n)
    {
        //one is not a prime number
        ArrayList<Integer> primesList = new ArrayList<Integer>();
        primesList.add(2);
        if(n<3)
            return 0;
        int count = 1;
        for(int i=3;i<n;i=i+2)
        {
            if(isPrime(i, primesList))
            {
                primesList.add(i);
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int num, ArrayList<Integer> primesList)
    {
        int i = 0;
        while(primesList.get(i) <= Math.sqrt(num))
        {
            if(num%primesList.get(i)==0)
                return false;
            i++;
        }
        return true;
    }
}
