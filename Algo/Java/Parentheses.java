class Parentheses
{
	public static void generate(int l, int r, String s, int n)
	{
		if(l>n || r>n)
			return;
		if(l+r==2*n)
		{
			System.out.println("parentheses: "+s);
		}
		else
		{
			if(l<n)
			{
				generate(l+1,r,s+"(", n);
			}
			if(r<n && r<l)
			{
				generate(l,r+1,s+")", n);
			}
		}
	}

	public static void main(String args[])
	{
		generate(0,0,"",3);
	}
}
