class SumSubset{
  public static void main(String[] args){
    SumSubset ss= new SumSubset();
    int[] array={3, 34, 4, 12, 5, 2};
    System.out.println(ss.isSubsetSum(array,array.length-1,2));
  }
  boolean isSubsetSum(int[] set, int n, int sum)
  {
   // Base Cases
   if (sum == 0)
     return true;
   if (n == 0 && sum != 0)
     return false;

   // If last element is greater than sum, then ignore it
   if (set[n-1] > sum)
     return isSubsetSum(set, n-1, sum);

   /* else, check if sum can be obtained by any of the following
      (a) including the last element
      (b) excluding the last element   */
   return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]);
 }
}
