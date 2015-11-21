/* http://www.redblobgames.com/pathfinding/a-star/implementation.html#cplusplus */
import java.util.HashSet;
class SquareGridWithWeights extends SquareGrid
{
	private int width;
	private int height;
	private HashSet<Location> forest;
	
	public SquareGridWithWeights(int width, int height)
	{
		super(width, height);
		this.width = width;
		this.height = height;
		this.forest = new HashSet<>();
	}

	public void addForest(Location l)
	{
		this.forest.add(l);
	}

	public boolean inForest(Location l)
	{
		return this.forest.contains(l);
	}

	public int cost(Location a, Location b)
	{
		return this.forest.contains(b)?5:1;
	}
}