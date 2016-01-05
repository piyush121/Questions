/* http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/ */
class BinomialCoefficients
{
	//C(n, k) = C(n-1, k-1) + C(n-1, k)
   	//C(n, 0) = C(n, n) = 1

   	public int combinations(int n, int k)
   	{
   		if(k==0 || k==n)
   			return 1;

   		return combinations(n-1, k-1) + combinations(n-1, k);
   	}

   	public static void main(String args[])
   	{
   		BinomialCoefficients bc = new BinomialCoefficients();
   		System.out.println(bc.combinations(5, 2));
   	}
}