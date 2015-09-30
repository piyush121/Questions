class BinaryPalindromes
{
	//range given 1-100
	public void printBinaryPalindrome()
	{
		for(int i=0;i<100;i++)
		{
			StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
			StringBuilder r = new StringBuilder(s).reverse();
			if(s.toString().equals(r.toString()))
				System.out.println(s);
		}
	}
	
	public static void main(String args[])
	{
		BinaryPalindromes b = new BinaryPalindromes();
		b.printBinaryPalindrome();
	}
}