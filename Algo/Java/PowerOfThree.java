/*https://leetcode.com/problems/power-of-three/*/
public class PowerOfThree
{
	public boolean isPowerOfThree(int n) 
    {
    	if(n==0)
    		return false;
        while(n!=1)
        {
        	//System.out.println(n);
            int remainder = n%3;
            if(remainder!=0)
                return false;
            n = n/3;
        }
        return true;
    }

    public static void main(String args[])
    {
    	PowerOfThree p = new PowerOfThree();
    	System.out.println(p.isPowerOfThree(6));
    }
}