/* http://www.geeksforgeeks.org/check-binary-representation-number-palindrome/ */
/* however the code is for printing all the binary palindromic substring in 
range 1-100*/
class BinaryPalindromes
{
	//range given 1-100
	public void printBinaryPalindrome()
	{
		//loop through the range
		for(int i=0;i<100;i++)
		{
			//get the binary representation of the number
			StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
			//get the reverse of the binary representation of the number
			StringBuilder r = new StringBuilder(s).reverse();
			//if both binary representation and its reverse are equal 
			//then print the number
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
