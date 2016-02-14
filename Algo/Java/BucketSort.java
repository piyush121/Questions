/* http://www.geeksforgeeks.org/bucket-sort-2/ */
import java.util.PriorityQueue;
import java.util.ArrayList;
class BucketSort
{
	public void bucketSort(double[] num)
	{
		//an arraylist of priority queues
		ArrayList<PriorityQueue<Double>> bucket = new ArrayList<PriorityQueue<Double>>(num.length);
		for(int i=0;i<num.length;i++)
		{
			bucket.add(new PriorityQueue<Double>());
		}
		//get index 
		// (Number * length of an arraylist) mod length of an arraylist
		for(int i=0;i<num.length;i++)
		{
			int index = (int)(num[i]*num.length)%num.length;
			bucket.get(index).add(num[i]);
		}
		//print the bucket
		System.out.println(bucket);
	}

	public static void main(String args[])
	{
		double [] arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
		BucketSort b = new BucketSort();
		b.bucketSort(arr);
	}
}
