/* http://www.redblobgames.com/pathfinding/a-star/implementation.html#cplusplus */
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.HashSet;
class DijkstraSquareGridWithWeight
{
	private int width;
	private int height;
	private SquareGridWithWeights graph;
	private HashMap<Location, Integer> costSoFar;
	private HashMap<Location, Location> cameFrom;
	private HashSet<Location> path;

	public DijkstraSquareGridWithWeight(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.graph = new SquareGridWithWeights(this.width, this.height);
		this.costSoFar = new HashMap<>();
		this.cameFrom = new HashMap<>();
		this.path = new HashSet<>();
	}	

	public void dijkstraSearch(Location start, Location end)
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
			for(Location next : this.graph.neighbors(curr))
			{
				//no need to check in cameFrom inorder to not miss shortest distance
				int cost = this.costSoFar.get(curr) + this.graph.cost(curr, next);
				if(!this.costSoFar.containsKey(next) || cost < this.costSoFar.get(next))
				{
					Location temp = new Location(next, cost);
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

	public void drawGrid(Location start, Location end)
	{
		for(int j=0;j<this.height; j++)
		{
			for(int i=0;i<this.width; i++)
			{
				Location l = new Location(i, j);

				if(!this.graph.passable(l))
					System.out.print("# ");
				else if(start.equals(l))
					System.out.print("* ");
				else if(end.equals(l))
					System.out.print("+ ");
				else if(this.cameFrom.containsKey(l))
				{
					Location from = cameFrom.get(l);
					if(from.x == l.x+1)
						System.out.print("\u2192 ");
					else if(from.x == l.x-1)
						System.out.print("\u2190 ");
					else if(from.y == l.y+1)
						System.out.print("\u2193 ");
					else if(from.y == l.y-1)
						System.out.print("\u2191 ");
				}
				else if(this.graph.inForest(l))
					System.out.print("@ ");
				else
					System.out.print(". ");
			}
			System.out.println();
		}
	}

	public void drawGridWithDistance(Location start, Location end)
	{
		for(int j=0;j<this.height; j++)
		{
			for(int i=0;i<this.width; i++)
			{
				Location l = new Location(i, j);

				if(!this.graph.passable(l))
					System.out.print("#\t");
				else if(start.equals(l))
					System.out.print("*\t");
				else if(end.equals(l))
					System.out.print("+\t");
				else if(this.costSoFar.containsKey(l))	
					System.out.print(this.costSoFar.get(l)+"\t");
				else 
					System.out.print(".\t");
			}
			System.out.println();
		}
	}

	public void drawGridWithPath(Location start, Location end)
	{
		for(int j=0;j<this.height; j++)
		{
			for(int i=0;i<this.width; i++)
			{
				Location l = new Location(i, j);

				if(!this.graph.passable(l))
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
		DijkstraSquareGridWithWeight d = new DijkstraSquareGridWithWeight(10, 10);

		d.graph.addWalls(new Location(1, 7), new Location(4, 9));
		d.graph.addForest(new Location(3, 4));d.graph.addForest(new Location(3, 5));
		d.graph.addForest(new Location(4, 1));d.graph.addForest(new Location(4, 2));
		d.graph.addForest(new Location(4, 3));d.graph.addForest(new Location(4, 4));
		d.graph.addForest(new Location(4, 5));d.graph.addForest(new Location(4, 6));d.graph.addForest(new Location(4, 7));
		d.graph.addForest(new Location(4, 8));d.graph.addForest(new Location(5, 1));d.graph.addForest(new Location(5, 2));
		d.graph.addForest(new Location(5, 3));d.graph.addForest(new Location(5, 4));d.graph.addForest(new Location(5, 5));
		d.graph.addForest(new Location(5, 6));d.graph.addForest(new Location(5, 7));d.graph.addForest(new Location(5, 8));
		d.graph.addForest(new Location(6, 2));d.graph.addForest(new Location(6, 3));d.graph.addForest(new Location(6, 4));
		d.graph.addForest(new Location(6, 5));d.graph.addForest(new Location(6, 6));d.graph.addForest(new Location(6, 7));
		d.graph.addForest(new Location(7, 3));d.graph.addForest(new Location(7, 4));d.graph.addForest(new Location(7, 5));

		Location start = new Location(1, 4);
		Location end = new Location(8, 5);

		d.drawGrid(start, end);
		System.out.println();
		d.dijkstraSearch(start, end);
		d.drawGridWithDistance(start, end);
		d.reconstructPath(start, end);
		d.drawGridWithPath(start, end);
	}
}	

