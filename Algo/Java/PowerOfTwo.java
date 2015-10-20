public class PowerOfTwo
{
  public static void main(String args[])
  {
    PowerOfTwo pot = new PowerOfTwo();
    System.out.println(pot.isPowerOfTwo(1));
  }

  public boolean isPowerOfTwo(int n)
  {
      int count = 0;
      while(n>0)
      {
          count = count + (n&1);
          n = n>>>1;
      }
      if(count==1)
          return true;
      else
          return false;
  }
}
