class UglyNumber
{
	public static void main(String args[])
	{
		UglyNumber u = new UglyNumber();
		//int num = 125;
		//int num = 14;
		//int num = 35;
		//int num = 30;
		//int num = 8;
		int num = 0;
		System.out.println(u.isUgly(num));
	}

	public boolean isUgly(int num)
	{
		if(num==0)
			return false;
		int[] m = {5,3,2};
		int pos=0;
		while(num!=1 && pos<m.length)
		{
			while(num%m[pos]==0)
				num = num/m[pos];
			pos++;
		}
		if(Math.abs(num)==1)
			return true;
		return false;
	}
}
