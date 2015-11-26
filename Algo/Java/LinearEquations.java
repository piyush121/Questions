/* http://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/ */

class LinearEquations
{
	
	public int solve(int[] coeff, int rhs)
	{
		return helper(coeff, rhs, 0);
	}

	public int helper(int[] coeff, int rhs, int start)
	{
		if(rhs==0)
		{
			System.out.println();
			return 1;
		}
		int result = 0;
		for(int i=start;i<coeff.length;i++)
		{
			if(rhs>=coeff[i])
			{
				System.out.println("coeff: "+coeff[i] + " i: "+i + " rhs: "+rhs);
				result += helper(coeff, rhs-coeff[i], i);
			}
		}
		return result;
	}

	public static void main(String args[])
	{
		int[] coeff = {1, 2};
		int rhs = 5;

		LinearEquations l = new LinearEquations();
		System.out.println(l.solve(coeff, rhs));
	}	
}