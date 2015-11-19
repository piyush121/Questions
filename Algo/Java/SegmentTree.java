/* http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/ */
/* https://leetcode.com/problems/range-sum-query-mutable/ */
/* http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/bin-tree.html */
class SegmentTree
{
	private int[] segment;
	private int[] arr;

	public SegmentTree(int[] arr)
	{
		this.arr = arr;
		//height of the segment tree 
		//we know the number of leaves in the tree which will be equal to 
		//the total number of elements in a array
		int h = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
		//nodes in a perfect binary tree = 2^(h+1) − 1 
		int size =  2 * (int)Math.pow(2, h) - 1;
		segment = new int[size];
		constructSegmentTree(arr, 0, arr.length-1, 0);
	}
	//left child of the node i can be found at 2*i + 1
	//right child of the node i can be found at 2*i + 2
	//the node will contain the sum of the left child and the right child
	public int constructSegmentTree(int[] arr, int start, int end, int currIndex)
	{
		if(start==end)
		{
			this.segment[currIndex] = arr[start];
			return arr[start];
		}
		int mid = getMid(start, end);
		this.segment[currIndex] = constructSegmentTree(arr, start, mid, 2*currIndex +1)
									+ constructSegmentTree(arr, mid+1, end, 2*currIndex + 2);
		return this.segment[currIndex];
	}

	public int getMid(int start, int end)
	{
		return start + (end-start)/2;
	}

	public int getSum(int i, int j)
	{
		return getSumHelper(0, this.arr.length-1, i, j, 0);
	}

	//if the node range (start, end) is within range [i, j]
	//then return the value of the node
	public int getSumHelper(int start, int end, int i, int j, int currIndex)
	{
		 // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (i <= start && j >= end)
            return segment[currIndex];
 
        // If segment of this node is outside the given range
        if (end < i || start > j)
            return 0;
 
        // If a part of this segment overlaps with the given range
        int mid = getMid(start, end);
        return getSumHelper(start, mid, i, j, 2 * currIndex + 1) +
                getSumHelper(mid + 1, end, i, j, 2 * currIndex + 2);
	}

	public void update(int i, int val)
	{
		if(i<0 || i>this.arr.length-1)
		{
			System.out.println("Invalid Input");
			return;
		}
		int diff = val - this.arr[i];
		this.arr[i] = val;
		updateHelper(0, this.arr.length-1, i, diff, 0);
	}

	public void updateHelper(int start,  int end, int i, int diff, int currIndex)
	{
		if(i < start || i > end)
			return;
		this.segment[currIndex] = this.segment[currIndex] + diff;
		if(end!=start)
		{
			int mid = getMid(start, end);
			updateHelper(start, mid, i, diff, 2* currIndex +1);
			updateHelper(mid+1, end, i, diff, 2* currIndex +2);
		}
	}

	public void print(int[] a)
	{
		for(int i: a)
			System.out.print(i+" ");
		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = {1, 3, 5, 7, 9, 11};
		SegmentTree s = new SegmentTree(arr);
		s.print(s.segment);
		System.out.println("Sum of values in given range = " + s.getSum(1, 3));
		s.update(1, 10);
		s.print(s.segment);
        System.out.println("Updated sum of values in given range = " + s.getSum(1, 3));
	}
}