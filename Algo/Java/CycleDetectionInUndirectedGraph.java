/* http://www.geeksforgeeks.org/detect-cycle-undirected-graph/ */
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class CycleDetectionInUndirectedGraph
{
	private static Graph graph;

	public boolean isCyclic()
	{
		boolean[] visited = new boolean[graph.vertices];
		Arrays.fill(visited, false); 

		for(int i=0;i<graph.vertices;i++)
		{
			if(helper(i, visited, -1))
				return true;
		}
		return false;
	}

	public boolean helper(int v, boolean[] visited, int parent)
	{
		visited[v] = true;

		for(int i : graph.adj.get(v))
		{
			if(!visited[i])
			{
				if(helper(i, visited, v))
					return true;
			}
			else if(i != parent)
				return true;
		}
		return false;
	}

	public static void main(String args[])
	{
		graph = new Graph(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 0);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		CycleDetectionInUndirectedGraph c = new CycleDetectionInUndirectedGraph();
		System.out.println(c.isCyclic());

		graph = new Graph(3);
		graph.addEdge(0, 1);
    	graph.addEdge(1, 2);
    	System.out.println(c.isCyclic());
	}
}

class Graph
{
	int vertices;
	Map<Integer, ArrayList<Integer>> adj;

	Graph(int v)
	{
		this.vertices = v;
		adj = new HashMap<>();
		for(int i=0; i<v; i++)
		{
			adj.put(i, new ArrayList<Integer>());
		}
	}

	public void addEdge(int a, int b)
	{
		//adding edge from a to b
		this.adj.get(a).add(b);
		//adding edge from b to a
		this.adj.get(b).add(a);
	}
}