/*
  There is a fence with n posts. Each post can be colored with k colors.

  You have to paint all posts such that no more than two adjacent fence posts
  has the same color.

  Return the total number of ways to paint the fence.
*/
class PaintFence{
  public static void main(String[] args){
    PaintFence pf = new PaintFence();
    System.out.println(pf.numWays(6,4));
  }
  public int numWays(int n,int k){
    int postBeforePrevious = k;
    int postPrevious = k;
    if(n==0)
      return 0;
    if(n==1)
      return k;
    if(k==1 && n>=3)
      return 0;
    int ways = postBeforePrevious*postPrevious;
    for(int i=3; i<=n; i++){
      if(postBeforePrevious==postPrevious){
        ways *= --postPrevious;
      }
      else{
        ways *= ++postPrevious;
        postBeforePrevious = postPrevious;
      }
    }
    return ways;
  }
}
