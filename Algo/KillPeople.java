import java.util.*;
class KillPeople
{
	public static void main(String args[])
	{
		LinkedList<Integer> arr = new LinkedList<Integer>();
		for(int i=0;i<100;i++)
		{
			arr.add(i+1);
		}
		while(arr.size()!=1)
		{
			for(int i=0;i<2;i++)
			{
				int temp = arr.removeFirst();
				arr.addLast(temp);
			}
			arr.removeLast();
		}

		System.out.println(arr);
	}
}
