/* https://www.hackerrank.com/challenges/board-cutting */
import java.util.*;
class CuttingBoards
{
    public static void main(String args[])
    {
        // helpers for input/output
        CuttingBoards solution = new CuttingBoards();
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0;i<testCases;i++)
        {
            int M, N;
            M = in.nextInt();
            N = in.nextInt();

            List<Integer> yList = new ArrayList<>();
            List<Integer> xList = new ArrayList<>();

            for(int j = 0;j<M-1;j++)
                yList.add(in.nextInt());
            for(int j = 0;j<N-1;j++)
                xList.add(in.nextInt());

            Collections.sort(yList, Collections.reverseOrder());
            Collections.sort(xList, Collections.reverseOrder());

            int result = 0;
            result  = solution.getCost(M, N, yList, xList);
            System.out.println( result );
        }
    }

    int getCost(int M, int N, List<Integer> yList, List<Integer> xList)
    {
        int y = 1;
        int x = 1;
        long totalCost = 0L;
        long mod = 1000000007L;
        for(int i = 0; i< (M+N-2);i++)
        {
            //System.out.println(i);
            //System.out.println(yList);
            //System.out.println(xList);
            //if(yList.isEmpty())
            //System.out.println("empty");
            if(!yList.isEmpty() && !xList.isEmpty() && yList.get(0) >= xList.get(0))
            {
                totalCost += ((long)yList.remove(0) * x);
                totalCost %= mod;
                ++y;
            }
            else if(!yList.isEmpty() && !xList.isEmpty() && xList.get(0) >= yList.get(0))
            {
                totalCost += ((long)xList.remove(0) * y);
                totalCost %= mod;
                ++x;
            }
            else if(!xList.isEmpty())
            {
                totalCost += ((long)xList.remove(0) * y);
                totalCost %= mod;
                ++x;
            }
            else if(!yList.isEmpty())
            {
                totalCost += ((long)yList.remove(0) * x);
                totalCost %= mod;
                ++y;
            }
        }
        return (int)(totalCost %= mod);
    }
}
