class Denominations
{
	static int[] deno = {25, 10, 5, 1};
	public static void findDenominations1(int amount, int n, String s, int prev)
	{
		if(n> amount)
			return;
		if(amount == n)
			System.out.println(s);
		else
		{
			for(int i=0;i<deno.length;i++)
			{
				if(prev>=deno[i])
					findDenominations1(amount, n+deno[i],s+deno[i]+" ", deno[i]);
			}
		}
	}

	public static void findDenominations(int amount, int n, String s, char prev)
	{
		if(n> amount)
			return;
		if(amount == n)
			System.out.println(s);
		else
		{
			if(prev=='q')
				findDenominations(amount, n+25,s+"q", 'q');
			if(prev == 'q' || prev=='d')
				findDenominations(amount, n+10,s+"d", 'd');
			if(prev=='q' || prev=='d' || prev=='n')
				findDenominations(amount, n+5,s+"n",'n');
			if(prev=='q' || prev=='d' || prev=='n' || prev=='p')
				findDenominations(amount, n+1,s+"p",'p');
		}
	}

	public static void main(String[] args)
	{
		findDenominations(15, 0, "", 'q');
		findDenominations1(15, 0, "",deno[0]);
	}
}
