/*
  There is a fence with n posts. Each post can be colored with k colors.

  You have to paint all posts such that no more than two adjacent fence posts
  has the same color.

  Return the total number of ways to paint the fence.
*/
class PaintFence{
  
  public int numWays(int n,int k){
    if(n == 0 || k == 0) return 0;
    int[] dp = new int[n];
    for(int i = 0; i < n; i++){
      if(i == 0){
        dp[i] = k;
      }
      else if(i == 1){
        dp[i] = k*k;
      }
      else{
        dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1);
      }
    }
    return dp[n-1];
  }

  public static void main(String[] args){
    PaintFence pf = new PaintFence();
    System.out.println(pf.numWays(3,2));
  }
}
