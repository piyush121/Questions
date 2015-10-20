/* https://leetcode.com/problems/sqrtx/ */
class Sqrt
{
	public static void main(String args[]) throws Exception
	{
		Sqrt solution = new Sqrt();
		System.out.println(solution.mySqrt(2147395599));
	}

	public int mySqrt(int x) throws Exception
	{
		if(x==0 || x==1)
			return x;
		long lo = 1;
		long hi = x;

		while(lo<hi)
		{
			long mid = (lo+hi)/2;
			//System.out.println("lo: "+lo+" mid: "+mid+" hi: "+hi);
			//Thread.sleep(2000);
			if(lo==mid)
				break;
			if(mid*mid > x)
				hi = mid;
			else
				lo = mid;
		}

		return (int)lo;
	}
}
