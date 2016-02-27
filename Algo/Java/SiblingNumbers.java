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

*/
