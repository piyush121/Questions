import java.util.Random;
class Quick
{
	public int[] partition(int[] num, int lo, int hi)
	{
		int pivotIndex = choosePivot(lo, hi);
		int pivot = num[pivotIndex];
		System.out.println(pivot);
		//swap the pivot with num[hi];
		num[pivotIndex] = num[hi];
		num[hi] = pivot;
		//printArray(num);
		int storeIndex =  lo;
		for(int i=lo;i<hi;i++)
		{
			//current element is less than the pivot
			//swap the element with num[storeIndex]
			if(num[i] < pivot)
			{
				int temp = num[i];
				num[i] = num[storeIndex];
				num[storeIndex] = temp;
				storeIndex++;
			}
			//printArray(num);
		}
		//swap num[hi] i.e chosen pivot with num[storeIndexz]
		num[hi] = num[storeIndex];
		num[storeIndex] = pivot;
		return num;
	}
	//choose the pivot randomly
	public int choosePivot(int lo, int hi)
	{
		Random r = new Random();
		return lo + (r.nextInt(hi-lo+1));
	}

	public void printArray(int[] num)
	{
		for(int x: num)
			System.out.print(x+" ");
		System.out.println();
	}

	public static void main(String args[])
	{
		int num[] = {0, 7, 8, 2, 3, 9, 4, 5};
		Quick q = new Quick();
		num = q.partition(num, 0, num.length-1);
		q.printArray(num);
	}
}
