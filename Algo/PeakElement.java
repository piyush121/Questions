class PeakElement
{
	public static int findPeakElement(int[] num)
	{
		if(num.length==1)
		{
			return 0;
		}
		else if(num.length==2)
		{
			if(num[0]>num[1])
				return 0;
			else	
				return 1;
		}
		if(num[0]>num[1])
		    return 0;
		else if(num[num.length-1]>num[num.length-2])
		    return num.length-1;
		for(int i=1;i<num.length-1;i++)
		{
			if(num[i]>num[i-1] && num[i]>num[i+1])
				return i;
		} 
	}
	//efficient by using binary search. treat it as a graph 
	//peak element will be right of increasing indexes and left of decreasing indexes
	public int findPeakElement(int[] num) 
	{ 
		int l = 0; 
		int r = num.length-1; 
		int mid = r/2; 
		while (l<r)
		{ 
			if(num[mid]<num[mid+1])
			{ 
				l=mid+1; 
			}
			else
			{ 
					r=mid; 
			}
			mid=(l+r)/2; 
		} 
		return l; 
	}
	
	public static void main(String args[])
	{
		int[] a = {2, 1, 0};
		System.out.println(findPeakElement(a));
	}
}
