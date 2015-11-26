/* http://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/ */

class CountWaysToCoverDistance
{
	public int count(int dist)
	{
		if(dist==0)
			return 1;
		if(dist < 0)
			return 0;
		return count(dist-1) + count(dist-2) + count(dist-3);
	}

	public static void main(String args[])
	{
		int dist = 4;
		CountWaysToCoverDistance c = new CountWaysToCoverDistance();
		System.out.println(c.count(dist));
	}
}