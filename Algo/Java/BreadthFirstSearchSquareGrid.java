/* http://www.redblobgames.com/pathfinding/a-star/implementation.html#cplusplus */
import java.util.LinkedList;
import java.util.HashMap;
class BreadthFirstSearchSquareGrid
{
	private int height;
	private int width;
	private SquareGrid graph;

	public BreadthFirstSearchSquareGrid(int width, int height)
	{
		this.height = height;
		this.width = width;
		this.graph = new SquareGrid(width, height);
		this.graph.addWalls(new Location(3, 3), new Location(5, 12));
		this.graph.addWalls(new Location(13, 4), new Location(15, 15));
		this.graph.addWalls(new Location(21, 0), new Location(23, 7));
		this.graph.addWalls(new Location(23, 5), new Location(26, 7));
	}

	public HashMap<Location, Location> bfs(Location start)	
	{
		LinkedList<Location> frontier = new LinkedList<>();
		HashMap<Location, Location> cameFrom = new HashMap<>();
		frontier.add(start);
		cameFrom.put(start, start);
		while(!frontier.isEmpty())
		{
			Location curr = frontier.poll();
			for(Location next : this.graph.neighbors(curr))
			{
				if(!cameFrom.containsKey(next))
				{
					frontier.add(next);
					cameFrom.put(next, curr);
				}
			}
		}
		return cameFrom;
	}

	public HashMap<Location, Location> bfsWithEarlyExit(Location start, Location end)
	{
		LinkedList<Location> frontier = new LinkedList<>();
		HashMap<Location, Location> cameFrom = new HashMap<>();
		frontier.add(start);
		cameFrom.put(start, start);
		while(!frontier.isEmpty())
		{
			Location curr = frontier.poll();
			if(curr.equals(end))
				break;
			for(Location next : this.graph.neighbors(curr))
			{
				if(!cameFrom.containsKey(next))
				{
					frontier.add(next);
					cameFrom.put(next, curr);
				}
			}
		}
		return cameFrom;
	}

	public void drawGrid(HashMap<Location, Location> cameFrom, Location start)
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
				else if(cameFrom.containsKey(l))
				{
					Location from = this.cameFrom.get(l);
					if(from.x == l.x+1)
					{
						System.out.print("\u2192 ");
					}
					else if(from.x == l.x-1)
					{
						System.out.print("\u2190 ");
					}
					else if(from.y == l.y+1)
					{
						System.out.print("\u2193 ");
					}
					else if(from.y == l.y-1)
					{
						System.out.print("\u2191 ");
					}
				}
			}
			System.out.println();
		}
	}

	public void drawGrid(HashMap<Location, Location> cameFrom, Location start, Location end)
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
				else if(cameFrom.containsKey(l))
				{
					Location from = cameFrom.get(l);
					if(from.x == l.x+1)
					{
						System.out.print("\u2192 ");
					}
					else if(from.x == l.x-1)
					{
						System.out.print("\u2190 ");
					}
					else if(from.y == l.y+1)
					{
						System.out.print("\u2193 ");
					}
					else if(from.y == l.y-1)
					{
						System.out.print("\u2191 ");
					}
				}
				else
				{
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}


	public static void main(String args[])
	{
		BreadthFirstSearchSquareGrid b = new BreadthFirstSearchSquareGrid(30 , 15);
		b.graph.drawGrid();
		Location start = new Location(7, 8);
		HashMap<Location, Location> cameFrom = b.bfs(start);
		b.drawGrid(cameFrom, start);
		System.out.println();
		Location end = new Location(17, 2);
		cameFrom = b.bfsWithEarlyExit(start, end);
		b.drawGrid(cameFrom, start, end);
	}
}