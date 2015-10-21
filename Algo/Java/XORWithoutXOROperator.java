/* http://www.geeksforgeeks.org/find-xor-of-two-number-without-using-xor-operator/?utm_source=feedburner&utm_medium=email&utm_campaign=Feed%3A+Geeksforgeeks+%28GeeksforGeeks%29 */

class XORWithoutXOROperator
{

	public int getXOR(int a, int b)
	{
		return ((~a & b) | (a & ~b));
	}

	public static void main(String args[])
	{
		XORWithoutXOROperator x = new XORWithoutXOROperator();
		System.out.println(x.getXOR(3,5));
	}
}