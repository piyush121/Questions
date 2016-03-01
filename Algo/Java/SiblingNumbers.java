/*
	two non-negative numbers are called siblings if they can be obtained 
	from each other by rearranging the digits of their decimal representations.
	for example, 123 and 213 are siblings, 535 and 355 are also siblings
*/
public class SiblingNumbers
{
	public static void main(String args[])
	{	
		SiblingNumbers s = new SiblingNumbers();
		System.out.println(s.isSibling(123, 213));
	}

	public boolean isSibling(int num1, int num2)
	{
		int[] countArray = new int[10];
		int p1 = num1;
		int p2 = num2;
		while(p1>0)
		{
			countArray[p1%10]++;
			p1 = p1/10;
		}

		while(p2>0)
		{
			countArray[p2%10]--;
			p2 = p2/10;
		}

		for(int i=0;i<10;i++)
		{
			if(countArray[i]!=0)
				return false;
		}
		return true;
	}
}

/*
	root@localhost: dwfDDayk(3sC
	
	select sensor_id, count(distinct event_type) as types
	from events
	group by sensor_id;

MapReduce 
MapReduce works by breaking the processing into two phases: the map phase and the reduce phase.
Each phase has key-value pairs as input and output, the types of which may be chosen by the
programmer.
The Map function that performs filtering and sorting and then outputs a set of records
of the form (key, data)
The Reduce function that performs a summary operation (such as counting the number 
of students in each queue, yielding name, frequencies) 


In general, there are multiple instances of the map program running on different nodes of a compute cluster. Each map instance is given a distinct portion of the input file by the MapReduce scheduler to process. 

As such, a single-threaded implementation of MapReduce will usually not be faster than a traditional (non-MapReduce) implementation, any gains are usually only seen with multi-threaded implementations

for example, a word count using MapReduce as a design Pattern



*/
