/* http://www.geeksforgeeks.org/detect-cycle-in-a-graph/ */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class CycleDetectionInDirectedGraph
{
	private static Graph graph;

	public boolean isCyclic()
	{
		boolean[] visited = new boolean[graph.vertices];
		Arrays.fill(visited, false); 
		Set<Integer> recStack = new HashSet<>();
		System.out.println(graph.vertices);
		for(int i=0;i<graph.vertices;i++)
		{
			if(helper(i, visited, recStack))
				return true;
		}
		return false;
	}

	public boolean helper(int v, boolean[] visited, Set<Integer> recStack)
	{
		System.out.println("v: "+v+" set: "+recStack);
		if(!visited[v])
		{
			visited[v] = true;
			recStack.add(v);
			for(int i : graph.adj.get(v))
			{
				if(!visited[i])
				{
					if(helper(i, visited, recStack))
						return true;
				}
				else if(recStack.contains(i))
					return true;
			}
		}
		recStack.remove(v);
		return false;
	}

	public static void main(String args[])
	{
		 graph = new Graph(4);
		 graph.addEdge(0, 1);
		 graph.addEdge(0, 2);
		 graph.addEdge(1, 2);
		 //graph.addEdge(2, 0);
		 graph.addEdge(2, 3);
		 graph.addEdge(3, 3);
		 CycleDetectionInDirectedGraph c = new CycleDetectionInDirectedGraph();
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
	}
}