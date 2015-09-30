/*https://www.hackerrank.com/challenges/flowers*/
import java.util.*;

class FriendsAndFlowers
{
    public static void main( String args[] )
    {
        // helpers for input/output
        FriendsAndFlowers solution = new FriendsAndFlowers();
        Scanner in = new Scanner(System.in);

        int N, K;
        N = in.nextInt();
        K = in.nextInt();

        List<Integer> C = new ArrayList<>();
        for(int i=0; i<N; i++)
        {
            C.add(in.nextInt());
        }
        Collections.sort(C, Collections.reverseOrder());
        int result = 0;
        result = solution.getPrice(C, K);
        System.out.println( result );
    }

    int getPrice(List<Integer> prices, int f)
    {
        int count = 0;
        int amount = 0;
        int[] flowers = new int[f];
        for(int price: prices)
        {
            amount += (flowers[count%f] + 1 ) * price;
            flowers[count%f]++;
            count++;
        }
        return amount;
    }
}
