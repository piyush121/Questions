class Challenge204I
{
	public static void printHyperBinary(int target)
	{
		int input = target;
		int count = 0;
		while(input > 0)
		{
			input = input/2;
			count++;
		}
		//System.out.println(count);
		find(target, 0, count,0, "");
	}
	
	public static void find(int target, int num,int count,int n, String s)
	{
		//System.out.println(count+" "+n);
		if(num>target)
		{
			return;
		}
		if(count == -1)
		{	
			if(target==num)
				System.out.println(s);
			return;
		}
		find(target, num + 0*(int)Math.pow(2,n),count-1, n+1 ,"0"+s);
		find(target, num + 1*(int)Math.pow(2,n),count-1, n+1 ,"1"+s);
		find(target, num + 2*(int)Math.pow(2,n),count-1, n+1, "2"+s);
	}
	
	public static void main(String args[])
	{
		Challenge204I.printHyperBinary(18);
	}