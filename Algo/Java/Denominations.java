/* http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/ */
class Denominations
{
	static int[] deno = {25, 10, 5, 1};
	public static void findDenominations1(int amount, int n, String s, int prev)
	{

		//check if the amount accumulated so far is greater than the 
		//amount in question
		if(n> amount)
			return;
		//if the amount is equal to the accumulated amount 
		//then print the formation string
		if(amount == n)
			System.out.println(s);
		else
		{
			//deno = {25, 10, 5, 1};
			for(int i=0;i<deno.length;i++)
			{
				if(prev>=deno[i])
					findDenominations1(amount, n+deno[i],s+deno[i]+" ", deno[i]);
			}
		}
	}

	//@amount : amount to be made from the change
	//q: quarter, d: dime, n:nickel, p:penny
	//@s : formation string
	//@n: amount accumulated so far
	public static void findDenominations(int amount, int n, String s, char prev)
	{
		//check if the amount accumulated so far is greater than the 
		//amount in question
		if(n> amount)
			return;
		//if the amount is equal to the accumulated amount 
		//then print the formation string
		if(amount == n)
			System.out.println(s);
		//if the accumulated amount is still less than the amount then
		//Note: while accumulating the amount we always follow the descending 
		//order that is first we check for quarter, then if there is no scope 
		//for quarter we will check for nickel and so on.
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
