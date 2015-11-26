/* http://www.redblobgames.com/pathfinding/a-star/implementation.html#cplusplus */
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
class AStarSearchSquareGridWithWeight
{
	private int width;
	private int height;

	private SquareGridWithWeights grid;
	private HashMap<Location, Location> cameFrom;
	private HashMap<Location, Integer> costSoFar;
	private HashSet<Location> path;

	public AStarSearchSquareGridWithWeight(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.grid = new SquareGridWithWeights(this.width, this.height);
		this.cameFrom = new HashMap<>();
		this.costSoFar = new HashMap<>();
		this.path = new HashSet<>();
	}

	public int heuristic(Location a, Location b)
	{
		//Manhattan distance on a square grid
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}

	public void aStarSearch(Location start, Location end)
	{
		PriorityQueue<Location> frontier = new PriorityQueue<>();
		frontier.add(new Location(start, 0));
		this.cameFrom.put(start, null);
		this.costSoFar.put(start, 0);

		while(!frontier.isEmpty())
		{
			Location curr = frontier.poll();
			if(curr.equals(end))
				break;
			for(Location next: this.grid.neighbors(curr))
			{
				int cost = this.costSoFar.get(curr) + this.grid.cost(curr, next);
				if(!costSoFar.containsKey(next) || cost < this.costSoFar.get(next))
				{
					int priority = cost + this.heuristic(curr, next);
					//setting priority as cost to be compared while inserting in priority
					Location temp = new Location(next, priority);
					//cost of the path remain same as in Dijkstra's Algorithm
					this.costSoFar.put(temp, cost);
					frontier.add(temp);
					this.cameFrom.put(next, curr);
				}
			}
		}
	}

	public HashSet<Location> reconstructPath(Location start, Location end)
	{
		Location curr = end;
		while(!curr.equals(start))
		{
			Location next = this.cameFrom.get(curr);
			path.add(next);
			curr = next;
		}
		return path;
	}

	public void drawGridWithPath(Location start, Location end)
	{
		for(int j=0;j<this.height; j++)
		{
			for(int i=0;i<this.width; i++)
			{
				Location l = new Location(i, j);

				if(!this.grid.passable(l))
					System.out.print("# ");
				else if(start.equals(l))
					System.out.print("* ");
				else if(end.equals(l))
					System.out.print("+ ");
				else if(this.path.contains(l))	
					System.out.print("o ");
				else 
					System.out.print(". ");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		AStarSearchSquareGridWithWeight a = new AStarSearchSquareGridWithWeight(10, 10);

		a.grid.addWalls(new Location(1, 7), new Location(4, 9));
		a.grid.addForest(new Location(3, 4));a.grid.addForest(new Location(3, 5));
		a.grid.addForest(new Location(4, 1));a.grid.addForest(new Location(4, 2));
		a.grid.addForest(new Location(4, 3));a.grid.addForest(new Location(4, 4));
		a.grid.addForest(new Location(4, 5));a.grid.addForest(new Location(4, 6));a.grid.addForest(new Location(4, 7));
		a.grid.addForest(new Location(4, 8));a.grid.addForest(new Location(5, 1));a.grid.addForest(new Location(5, 2));
		a.grid.addForest(new Location(5, 3));a.grid.addForest(new Location(5, 4));a.grid.addForest(new Location(5, 5));
		a.grid.addForest(new Location(5, 6));a.grid.addForest(new Location(5, 7));a.grid.addForest(new Location(5, 8));
		a.grid.addForest(new Location(6, 2));a.grid.addForest(new Location(6, 3));a.grid.addForest(new Location(6, 4));
		a.grid.addForest(new Location(6, 5));a.grid.addForest(new Location(6, 6));a.grid.addForest(new Location(6, 7));
		a.grid.addForest(new Location(7, 3));a.grid.addForest(new Location(7, 4));a.grid.addForest(new Location(7, 5));

		Location start = new Location(1, 4);
		Location end = new Location(8, 5);

		a.aStarSearch(start, end);
		a.reconstructPath(start, end);
		a.drawGridWithPath(start, end);
	}
}