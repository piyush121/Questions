public class Location implements Comparable<Location>
{
	public int x;
	public int y;
	public int cost;

	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Location(int x, int y, int cost)
	{
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	public Location(Location s, int cost)
	{
		this(s.x, s.y);
		this.cost = cost;
	}

	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x;
		result = prime * result + this.y;
		return result;
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(this.getClass()!=obj.getClass())
			return false;
		Location l = (Location) obj;
		if(this.x != l.x)
			return false;
		if(this.y != l.y)
			return false;
		return true;
	}

	public String toString()
	{
		return "("+this.x+", "+ this.y+")";
 	}

 	public int compareTo(Location l)
 	{
 		return this.cost - l.cost;
 	}
}
