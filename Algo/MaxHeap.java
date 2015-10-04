class MaxHeap
{
	private static int[] heap;
	private static int insertIndex = 1;

	MaxHeap(int size)
	{
		heap = new int[size+1];
		heap[0] = Integer.MIN_VALUE;
	}

	public static void insert(int num)
	{
		if(insertIndex<heap.length)
		{
			heap[insertIndex] = num;
			heapify();
			insertIndex++;
		}
		printArray();
	}

	public static void heapify()
	{
		if(insertIndex==1)
			return;
		else
		{
			int currIndex = insertIndex;
			//System.out.println("currIndex: "+currIndex+" "+heap[currIndex]);
			int parentIndex = currIndex/2;
			//System.out.println("parentIndex: "+ parentIndex+" "+heap[parentIndex]);
			while(heap[parentIndex]<heap[currIndex] && parentIndex !=0)
			{
				int temp = heap[currIndex];
				heap[currIndex] = heap[parentIndex];
				heap[parentIndex]  = temp;
				currIndex = parentIndex;
				parentIndex = parentIndex/2;
				//System.out.println("currIndex: "+currIndex);
				//System.out.println("parentIndex: "+ parentIndex);
			}
		}
	}

	public static void printArray()
	{
		for(int num:heap)
			System.out.print(num+"\t");
		System.out.println();
	}

	public static void sort()
	{
		int[] sortedHeap = new int[heap.length];
		for(int i=0;i<heap.length;i++)
			sortedHeap[i] = heap[i];
		int lastIndex = sortedHeap.length-1;
		while(lastIndex != 1)
		{
			int temp = sortedHeap[lastIndex];
			sortedHeap[lastIndex] = sortedHeap[1];
			sortedHeap[1] = temp;
			int currIndex = 1;
			while(currIndex <= sortedHeap.length/2 || )
			{
				if(sortedHeap[currIndex]<sortedHeap[2*currIndex])
				{
					int temp1 = sortedHeap[currIndex];
					sortedHeap[currIndex] = sortedHeap[2*currIndex];
					sortedHeap[2*currIndex] = sortedHeap[currIndex];
					if(2*currIndex<sortedHeap.length)
					{
						currIndex = 2*currIndex;
						System.out.println("currIndex: "+currIndex);
					}
				}
				else if(sortedHeap[currIndex]<sortedHeap[2*currIndex+1])
				{
					int temp1 = sortedHeap[currIndex];
					sortedHeap[currIndex] = sortedHeap[2*currIndex+1];
					sortedHeap[2*currIndex+1] = sortedHeap[currIndex];
					if(2*currIndex+1 < sortedHeap.length)
					{
						currIndex = 2*currIndex+1;
						System.out.println("currIndex: "+currIndex);
					}
				}
				for(int num:sortedHeap)
					System.out.print(num+"\t");
				System.out.println();
			}
			lastIndex --;
			for(int num:sortedHeap)
				System.out.print(num+"\t");
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		MaxHeap heap = new MaxHeap(7);
		insert(1);
		insert(2);
		insert(3);
		insert(4);
		insert(5);
		insert(6);
		insert(7);
		sort();
	}
}
