class Queen8
{
	static int[] columnsForRows = new int[8];
	public static boolean check(int row)
	{
		for(int i=0;i<row;i++)
		{
			int diff =(int)Math.abs(columnsForRows[row]-columnsForRows[i]);
			if(columnsForRows[i]==columnsForRows[row] || diff == row-i)
				return false;
		}
		return true;
	}

	public static void placeQueen(int row)
	{
		if(row==8)
		{
			printBoard();
			System.out.println();
			return;
		}
		for(int i=0;i<8;i++)
		{
			columnsForRows[row] = i;
			if(check(row))
				placeQueen(row+1);
		}
	}

	public static void printBoard()
	{
		for(int i=0;i<8;i++)
		{
			int k = columnsForRows[i];
			for(int j=0;j<8;j++)
			{
				if(j==k)
					System.out.print("x");
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		placeQueen(0);
	}
}
