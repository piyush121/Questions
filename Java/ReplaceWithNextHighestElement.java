class ReplaceWithNextHighestElement
{
	public int[] replace(int[] arr)
	{
		
		int max = arr[arr.length-1];
		arr[arr.length-1] = -1;
		for(int i = arr.length-2;i>=0;i-- )
		{
			if(arr[i]>max)
				max = arr[i];
			else if(arr[i]<max)
				arr[i] = max;
		}
		return arr;
	}
	
	public static void main(String args[])
	{
		int[] arr ={5, 2, 8, 6, 1, 3};
		ReplaceWithNextHighestElement r = new ReplaceWithNextHighestElement();
		int[] b = r.replace(arr);
		
		for(int x: b)
			System.out.print(x+" ");
	}
}