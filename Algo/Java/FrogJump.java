import java.util.HashMap;
import java.util.Map;
class FrogJump
{
     public static void main(String args[])
    {
        int[] A = {1, 3, 1, 4, 2, 5};
        FrogJump solution = new FrogJump();
        System.out.println(solution.jump(A, 7, 3));
    }

    public int jump(int[] A, int X, int D)
    {
        int dp[] = new int[X+1];
        dp[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length;i++)
        {
            map.put(A[i],i);
        }
        helper(A, X, D, dp, map);
        return dp[X];
    }

    public void helper(int[] A, int X, int D, int[] dp, Map<Integer, Integer> map)
    {

        for(int i=1;i<dp.length;i++)
        {
            if(map.get(i)!=null && map.get(i)>dp[i-1]+1)
            {
                dp[i] = map.get(i);
            }
            else
            {
              if(map.get(i)!=null)
                dp[i] = Math.min(dp[i-1], map.get(i))+1;
              else
                dp[i] = dp[i-1] + 1;
            }
        }
    }
}
