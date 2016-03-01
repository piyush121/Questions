/* https://leetcode.com/problems/find-peak-element/ */

class PeakElement
{
	public static int findPeakElement(int[] num)
	{
		//if the length of array is 1 then return 0
		if(num.length==1)
		{
			return 0;
		}
		//if the length of the array is 2 
		//if num[0] > num[1] return num[0]
		//else return num[1]
		else if(num.length==2)
		{
			if(num[0]>num[1])
				return 0;
			else
				return 1;
		}
		//check boundary elements of the array 
		//if num[0] > num[1] then return 0
		if(num[0]>num[1])
		    return 0;
		else if(num[num.length-1]>num[num.length-2])
		    return num.length-1;
		//loop through the array
		for(int i=1;i<num.length-1;i++)
		{
			//check if num[i] is greater than the element on its left and right
			//then return i
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
