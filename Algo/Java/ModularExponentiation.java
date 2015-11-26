/* http://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/?utm_source=feedburner&utm_medium=email&utm_campaign=Feed%3A+Geeksforgeeks+%28GeeksforGeeks%29 */

class ModularExponentiation
{
	public int modExp(int x, int y, int mod)
	{
		int result  = 1;
		while(y>0)
		{
			//to check if y is odd
			//LSB of an odd will be 1
			if((y & 1) == 1)
			{
				result = (result * x) % mod;
			}

			y >>=1;
			x =  (x * x) % mod; 
		}
		return result;
	}
	
	public static void main(String args[])
	{
		ModularExponentiation m = new ModularExponentiation();
		System.out.println(m.modExp(2, 5, 13));
	}
}