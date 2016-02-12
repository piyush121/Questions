/* http://www.geeksforgeeks.org/square-root-of-an-integer/ */
class SquareRoot
{
	//the idea is to use binary search to find the square roor of the number
	public static double findSquareRoot(double num)
	{

		double lo = 0;
		//set hi equal to number itself
		//the square root of number should lie between 0 and number itself 
		double hi = num;
		double mid = (hi - lo)/2;
		//loop until the (mid)^2-num is less than accepted error
		while(Math.abs(mid*mid - num) > 0.000000000001)
		{
			//if the mid^2 is greater than the number
			//then the hi should be updated to mid
			//and mid = lo + (hi-lo)/2
			if(mid*mid > num)
			{
				hi = mid;
				mid = lo +(hi - lo)/2;
			}
			//if mid^2 is less than the number
			//then the lo should be updated to mid
			else
			{
				lo = mid;
				mid = mid + (hi-lo)/2;
			}
		}
		return mid;
	}

	public static void main(String args[])
	{
		System.out.println(SquareRoot.findSquareRoot(5));
	}
}
