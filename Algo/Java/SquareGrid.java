/* http://www.redblobgames.com/pathfinding/a-star/implementation.html#cplusplus */
import java.util.ArrayList;
import java.util.HashSet;
public class SquareGrid
{
	private int width;
	private int height;

	private final ArrayList<Location> dirs;
	//set of obstacles/non passable walls
	private HashSet<Location> walls;

	public SquareGrid(int width, int height)
	{
		this.width = width;
		this.height = height;

		this.dirs = new ArrayList<>();
		dirs.add(new Location(1, 0)); 	//right
		dirs.add(new Location(-1, 0)); 	//left
		dirs.add(new Location(0, 1)); 	//up
		dirs.add(new Location(0, -1)); 	//down

		this.walls = new HashSet<>();
	}

	//check if the location is valid
	public boolean inBounds(Location l)
	{
		return 0 <= l.x && l.x < this.width && 0 <= l.y && l.y < this.height;
	}

	//check if the location denotes the wall or not
	public boolean passable(Location l)
	{
		return !walls.contains(l);
	}

	//wall is defined by topLeft and bottomRight location
	public void addWalls(Location l1, Location l2)
	{
		for(int j=l1.y; j<l2.y; ++j)
		{
			for(int i=l1.x; i<l2.x; ++i)
			{
				this.walls.add(new Location(i, j));
			}
		}
	}

	public ArrayList<Location> neighbors(Location l)
	{
		ArrayList<Location> results = new ArrayList<>();
		int x = l.x;
		int y = l.y;
		for(Location dir : this.dirs)
		{
			int dx = dir.x;
			int dy = dir.y;
			Location next = new Location(x+dx, y+dy);
			if(this.inBounds(next) && this.passable(next))
			{
				results.add(next);
			}
		}
		return results;
	}

	public void drawGrid()
	{
		for(int j=0;j<height;j++)
		{
			for(int i=0;i<width;++i)
			{
				if(!this.walls.contains(new Location(i, j)))
					System.out.print("."+" ");
				else
					System.out.print("#"+" ");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		SquareGrid s = new SquareGrid(30, 15);
		s.addWalls(new Location(3, 3), new Location(5, 12));
		s.addWalls(new Location(13, 4), new Location(15, 15));
		s.addWalls(new Location(21, 0), new Location(23, 7));
		s.addWalls(new Location(23, 5), new Location(26, 7));
		s.drawGrid();
	}
}



