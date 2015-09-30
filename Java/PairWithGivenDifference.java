class PairWithGivenDifference
{
	public boolean findPair(int[] a, int diff)
	{
		int i=0;
		int j=0;
		
		while(i<a.length && j<a.length)
		{
			if(i!=j && a[j]-a[i]==diff)
			{
				System.out.println(a[i]+" "+a[j]);
				return true;
			}
			else if(a[j]-a[i]<diff)
			{
				j++;
			}
			else if(a[j]-a[i]>diff)
			{
				i++;
			}
		}
		System.out.println("No such Pair");
		return false;
	}
	
	public static void main(String args[])
	{
		PairWithGivenDifference p = new PairWithGivenDifference();
		int arr[] = {1, 8, 30, 40, 100};
		p.findPair(arr, 60);
	}
}