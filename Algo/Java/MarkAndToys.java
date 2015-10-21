/* https://www.hackerrank.com/challenges/mark-and-toys */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MarkAndToys
{
    public static void main(String args[])
    {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        //int prices[]=new int[n];
        List<Integer> prices = new ArrayList<>();
        for(int i=0;i<n;i++) prices.add(stdin.nextInt());
        Collections.sort(prices);
        int answer = 0;
        // Compute the final answer from n,k,prices
        System.out.println(answer);
    }

    int getToys(List<Integer> prices, int amount)
    {
        int count=0;
        for(Integer price: prices)
        {
            if(price < amount)
            {
                amount -= price;
                count++;
            }
        }
        return count;
    }
}
