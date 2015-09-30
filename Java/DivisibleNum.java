class DivisibleNum
{
	public static int findDivisibleNum(int num, int binNum)
	{
		if(binNum>=Integer.MAX_VALUE || binNum <=0)
			return Integer.MAX_VALUE;
		if(binNum%num==0)
		{
			return binNum;
		}
		else
		{
			int num1 = findDivisibleNum(num, binNum*10+0);
			int num2 = findDivisibleNum(num, binNum*10+1);
			return Math.min(num1, num2);
		}
	}
	
	public static void main(String args[])
	{
		System.out.println(findDivisibleNum(101, 1));
	}
}


 