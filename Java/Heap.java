class Heap
{
	private int[] heap;
	private int heapSize;
	
	public Heap(int heapSize, int[] heap)
	{
		this.heapSize = heapSize;
		this.heap = heap;
	}
	
	public void maxHeapify(int index)
	{
		int leftIndex = index<<1;
		int rightIndex = (index<<1) + 1;
		
		int largest = index;
		System.out.println("leftIndex:"+leftIndex+" rightIndex: "+rightIndex+" largest: "+largest+" heapSize: "+heapSize);
		if(leftIndex > heapSize)
			return;
		if(leftIndex <= heapSize && heap[index] < heap[leftIndex])
		{	
			largest = leftIndex;
		}
		if(rightIndex <= heapSize && heap[largest] < heap[rightIndex])
		{
			largest = rightIndex;
		}
		if(largest!=index)
		{
			int temp = heap[largest];
			heap[largest] = heap[index];
			heap[index] = temp;
		}
		else 
		{
			return;
		}
		printHeap();
		System.out.println();
		maxHeapify(largest);
	}
	
	public void buildMaxHeap()
	{
		for(int i =(heap.length-1)/2;i>=1;i--)
			maxHeapify(i);
	}
	
	public void heapSort()
	{
		buildMaxHeap();
		for(int i=heap.length-1;i>=2;i--)
		{
			int temp = heap[i];
			heap[i] = heap[1];
			heap[1] = temp;
			heapSize = heapSize - 1;
			maxHeapify(1);
			//heapSize--;
		}
		printHeap();
	}
	
	public void printHeap()
	{
		for(int i=1;i<=heap.length-1;i++)
			System.out.print(heap[i]+" ");
	}
	
	public static void main(String args[])
	{
		int[] a = {Integer.MIN_VALUE, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Heap h = new Heap(9, a);
		//h.buildMaxHeap();
		h.printHeap();
		h.heapSort();
		//h.maxHeapify(1);
		//h.printHeap();
	}
}