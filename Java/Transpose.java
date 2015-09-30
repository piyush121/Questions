class Transpose //Square Matrix
{
	public int[][] transpose(int[][] a)
	{
		//int[][] b = new int[a.length][a.length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<=i;j++)
			{
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
		return a;
	}
	
	public static void main(String args[])
	{
		Transpose t = new Transpose();
		int[][] a = {{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,16}};
		int[][] b = t.transpose(a);
		for(int []x: b)
		{
			for(int y: x)
			{
				System.out.print(y+" ");
			}
			System.out.println();
		}
	}
}