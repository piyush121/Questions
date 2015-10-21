class AssemblyLine
{
	private int[] f1;
	private int[] f2;
	private int[][] l;
	private int f;
	private static 	int last;
	public void fastestWay(int[][] a, int[][] t, int[] e, int[] x)
	{
		f1 = new int[a.length];
		f2 = new int[a.length];
		l = new int[a.length][2];
		l[0][0] = -1;
		l[0][1] = -1;

		f1[0] = a[0][0] + e[0];
		f2[0] = a[0][1] + e[1];
		System.out.print(f1[0]+"\t"+f2[0]+"\n");
		for(int i=1;i<f1.length;i++)
		{
			if(f1[i-1]+a[i][0] <= f2[i-1] +t[i-1][1] + a[i][0])
			{
				f1[i] = f1[i-1] + a[i][0];
				l[i][0] = 1;
				//System.out.print("if"+f1[i-1]+" "+a[i][0]+" "+f1[i]+"\t");
			}
			else
			{
				f1[i] = f2[i-1] + t[i-1][1] + a[i][0];
				l[i][0] = 2;
				//System.out.print("else"+f1[i]+"\t");
			}
			//System.out.println(f1[i-1]);System.out.println(t[i-1][0]);
			//System.out.println(a[i][0]);
			if(f2[i-1]+a[i][1] <= f1[i-1]+t[i-1][0]+a[i][1])
			{
				f2[i] = f2[i-1] + a[i][1];
				l[i][1] = 2;
				//System.out.print("if"+f2[i-1]+" "+a[i][1]+" "+f2[i]+"\n");
			}
			else
			{
				f2[i] = f1[i-1] + t[i-1][0] + a[i][1];
				l[i][1]= 1;
				//System.out.print("else"+f2[i]+"\n");
			}
		}
		if(f1[f1.length-1]+x[0] <= f2[f2.length-1]+x[1])
		{
			f = f1[f1.length-1] + x[0];
			last = 1;
		}
		else
		{
			f = f2[f2.length-1]+x[1];
			last = 2;
		}
		// for(int i=0;i<l.length;i++)
		// {
			// System.out.println(a[i][0]+"\t"+a[i][1]);
		// }
		// for(int i=0;i<t.length;i++)
		// {
			// System.out.println(t[i][0]+"\t"+t[i][1]);
		// }
		//for(int i=0;i<f1.length;i++)
		//{
		//	System.out.println(f1[i]+"\t"+f2[i]);
		//}
		// for(int i=0;i<l.length;i++)
		// {
			// System.out.println(l[i][0]+"\t"+l[i][1]);
		// }
	}

	public void printStations()
	{
		int x = last;
		System.out.println("line " + x + " station "  + l.length);
		for(int j = l.length-1; j>=1;j--)
		{
			x = l[j][x-1];
			System.out.println("line "+ x + " station " + j);
		}
	}

	public static void main(String args[])
	{
		int[][] a = {{7,8},{9,5},{3,6},{4,4},{8,5},{4,7}};
		int[][] t = {{2,2},{3,1},{1,2},{3,2},{4,1}};
		int[] e = new int[2];
		e[0] = 2;e[1] = 4;
		int[] x = new int[2];
		x[0] = 3;x[1] = 2;
		AssemblyLine asm = new AssemblyLine();
		asm.fastestWay(a,t,e,x);
		//asm.printStations();
		asm.printStationsInorder(last,6);
	}

	public void printStationsInorder(int x, int n)
	{
		if(x==-1)
		{
			return;
		}
		printStationsInorder(l[n-1][x-1],n-1);
		System.out.println("line "+ x + " station " + n);
	}
}
