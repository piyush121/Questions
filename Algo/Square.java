class Square //using bitmanipulation without using */
{
	public int square(int num)
	{
		if(num==0)
			return 0;
		if(num<0)
			num = -num;
		int x = num>>1;
		System.out.println("x: "+x);
		if((num&1)==1)
		{
			return (square(x)<<2) + x<<2 +1;
		}
		else
		{
			return (square(x)<<2);
		}
	}

	public static void main(String args[])
	{
		Square s = new Square();
		System.out.println(s.square(3));
	}
}
