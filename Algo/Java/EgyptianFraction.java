/* http://www.geeksforgeeks.org/greedy-algorithm-egyptian-fraction/ */

class EgyptianFraction
{
	public void printFraction(int nr, int dr)
	{
		if(nr==0 || dr == 0)
			return;
		//if denominator is multiple of numerator
		if(dr%nr == 0)
		{
			System.out.println(" 1/"+(dr/nr));
			return;
		}

		//if numerator is multiple of denominator
		if(nr%dr==0)
		{
			System.out.println(nr/dr);
			return;
		}
		// if numerator is greater than denominator
		// 7/2 -> 1 + 1 + 1 + 1/2
		if(nr > dr)
		{
			System.out.print(" 1 + ");
			printFraction(nr-dr, dr);
			return;
		}

		if(nr < dr)
		{
			int x = 1+ dr/nr;
			System.out.print(" 1/"+x+" + ");
			printFraction((nr*x) - dr, dr*x);
			return;
		}
	}
	public static void main(String args[])
	{
		EgyptianFraction e = new EgyptianFraction();
		e.printFraction(6, 14);
		System.out.println(Math.ceil(14/6));
		//e.printFraction(7, 2);
	}
}