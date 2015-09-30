class PushZerosToTheEnd
{
	public void pushZeros(int[] a)
	{
		int count=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=0)
				a[count++] = a[i];
		}
		while(count<a.length)
		{
			a[count] = 0;
			count++;
		}
		for(int x: a)
			System.out.print(x+" ");
		System.out.println("count: "+count);
	}
	
	public static void main(String args[])
	{
		PushZerosToTheEnd p = new PushZerosToTheEnd();
		int[] a = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		p.pushZeros(a);
	}
}