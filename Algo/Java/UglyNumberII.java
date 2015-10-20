/* https://leetcode.com/problems/ugly-number-ii/ */

//generate n-th ugly number
class UglyNumberII
{
	// Assume you have Uk, the kth ugly number. 
	// Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
	public int nthUglyNumber(int n)
	{
		if(n<=0)
			return -1;
 		if(n<=3)
 			return n;
 		int[] arr = new int[n+1];
 		arr[0] = -1;
 		arr[1] = 1;
 		arr[2] = 2;
 		arr[3] = 3;
 		arr[4] = 5;
 		int pos = 2;
 		for(int i = 5;i<n+1;i++)
 		{
 			arr[i] = min(arr[pos] * 2, arr[pos] * 3, arr[pos] * 5);
 			pos++;
 		}
 		for(int i=0;i<arr.length;i++)
 			System.out.print(arr[i]+" ");
 		return arr[n];
    }

    public int min(int a , int b, int c)
    {
    	int min = a;
    	if(b < min)
    		min = b;
    	if(c < min)
    		min = c;
    	return min;
    }

	public static void main(String args[])
	{
		UglyNumberII u = new UglyNumberII();
		System.out.println(u.nthUglyNumber(10));
	}
}