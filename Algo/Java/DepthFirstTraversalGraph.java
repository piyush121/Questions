/* http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/ */
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class DepthFirstTraversalGraph
{
	private Map<Integer, ArrayList<Integer>> graph;
	private int N;//number of vertices in graph
	private boolean[] visited;

	public DepthFirstTraversalGraph()
	{
		graph = new HashMap<>();
	}

	public void addEdge(int a, int b)
	{
    	if(graph.get(a) != null)
    	{
      		graph.get(a).add(b);
    	}
    	else
    	{
    		ArrayList<Integer> edges = new ArrayList<>();
    		edges.add(b);
    		graph.put(a, edges);
    	}
  	}

	public void dfs()
	{
		this.N = this.graph.size();
		this.visited = new boolean[N];
		Arrays.fill(visited, false);

		for(Integer i:this.graph.keySet())
		{
			if(visited[i]==false)
				dfsUtil(i, visited);
		}
	}

	public void dfsUtil(int vertex, boolean[] visited)
	{
		//Mark the current node visited 
		visited[vertex]=true;
		//print the node
		System.out.print(vertex+"\t");
		//visit all the adjacent nodes which are not visited before
		ArrayList<Integer> adjacent = this.graph.get(vertex);
		for(int i=0;i<adjacent.size();i++)
		{
			Integer v = adjacent.get(i);
			if(this.visited[v]!=true)
				dfsUtil(v, visited);
		}
	}

	public static void main(String args[])
	{
		DepthFirstTraversalGraph dft = new DepthFirstTraversalGraph();
		dft.addEdge(0, 1);
		dft.addEdge(0, 2);
		dft.addEdge(1, 2);
		dft.addEdge(2, 0);
		dft.addEdge(2, 3);
		dft.addEdge(3, 3);
		dft.addEdge(4, 5);
		dft.addEdge(5, 5);
		dft.dfs();
	}
}
