class HW6
{
	public static final int N = Integer.MIN_VALUE;
	public void findPath(int[][] a)
	{
		helper(a, 0, 0, "", 0);
	}
	
	public void helper(int[][]a, int m, int n, String pattern, int sum)
	{
		if( m==a.length-1 && n==a[a.length-1].length-1)
		{
			sum = eval(sum, a[m][n]);
			System.out.println(pattern+a[m][n] + " sum: "+ sum);
			//sum =0;
			return;
		}
		else
		{
			if(m< a.length && n<a[a.length-1].length && a[m][n]!=0 && a[m][n]!=N) 
			{
				sum = eval(sum, a[m][n]);
				helper(a, m+1,n , pattern+a[m][n]+" ", sum);
				helper(a, m, n+1, pattern+a[m][n]+" ", sum);
			}
		}
	}
	
	public int eval(int sum, int opt)
	{
		switch(opt)
		{
			case -1: return 0;
			case -2: return sum/2;
			default: return sum + opt; 
		}
	}
	
	public static void main(String args[])
	{
		int[][] a = {
					 {9, -1, 2, 0}, 
					 {1, 8, -1, 4},
					 {1, N, N, 1},
					 {1, 1, 1, 2}
				};
		HW6 h = new HW6();
		h.findPath(a);
	}
}

{9, -1, 2, 0}, 
{1, 8, -1, 4},
{1, N, N, 1},
{1, 1, 1, 2}

{16D, 7D(-1), 7D(-1), -1}
{7D, 7R(-1), 7R(-1), 7D}
{6D, 	N, 	N, 	3D}  
{5R, 	4R, 3R, 2}