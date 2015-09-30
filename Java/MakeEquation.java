class MakeEquation
{
	public int eval(int a, String s, int b)
	{
		switch(s)
		{
			case "+": return a+b;
			case "-": return a-b;
		}
		return -1;	
	}
	
	public boolean isValid(int exp, int target)
	{
		if(exp<=target)
			return true;
		else
			return false;
	}
	
	public void makeEquation(int[] a, int target)
	{
		helper(a, target, a[0], ""+a[0], 1);
	}
	
	public void helper(int[] a, int target, int sum, String s, int index)
	{
		System.out.println("s: "+s+" index: "+index + " sum: "+sum);
		if(sum==target && index==a.length)
			System.out.println(s);
		if(isValid(sum, target))
		{
			if(index<a.length)
			{
				helper(a, target, eval(sum, "+", a[index]), s+"+"+a[index], index+1);
				helper(a, target, eval(sum, "-", a[index]), s+"-"+a[index], index+1);
			}
		}
	}
	
	public static void main(String args[])
	{
		int[] a ={1, 2, 3, 4, 5};
		int target = 5;
		MakeEquation e = new MakeEquation();
		e.makeEquation(a, target);
	}
}