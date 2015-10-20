import java.util.List;
import java.util.ArrayList;
class AdjacencyList
{
	static List<List<Integer>> adj;
	List<List<Integer>> tp = new ArrayList<List<Integer>>();
	int vertices;

	AdjacencyList(int vertices)
	{
		this.vertices = vertices;
		adj = new ArrayList<List<Integer>>();
		for(int i=0;i<vertices;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		System.out.println(adj);
	}

	public void createList()
	{
		int count = 1;
		for(int i=0;i<this.vertices;i++)
		{
			for(int j=0;j<this.vertices;j++)
			{
				adj.get(i).add(count++);
			}
		}

		System.out.println(adj);
	}

	public void transpose(List<List<Integer>> adj)
	{
		for(int i=0;i<adj.size();i++)
		{
			tp.add(new ArrayList<Integer>());
		}
		for(int i=0;i<adj.size();i++)
		{
			for(int j=0;j<adj.get(i).size();j++)
			{
				tp.get(adj.get(i).get(j)).add(i);
			}
		}
		System.out.println(tp);
	}

	public static void main(String args[])
	{
		AdjacencyList a = new AdjacencyList(6);
		adj.get(0).add(1);
		adj.get(0).add(3);
		adj.get(1).add(4);
		adj.get(2).add(5);
		adj.get(2).add(4);
		adj.get(3).add(1);
		adj.get(4).add(3);
		adj.get(5).add(5);
		//a.createList();
		System.out.println(adj);
		a.transpose(adj);
	}
}
