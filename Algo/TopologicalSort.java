/* http://www.geeksforgeeks.org/topological-sorting/ */
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

class TopologicalSort
{
	private Map<Integer, ArrayList<Integer>> graph;
	private int N;//number of vertices in graph
	private boolean[] visited;
	private Stack<Integer> stack;

	public TopologicalSort()
	{
		graph = new HashMap<>();
		stack = new Stack<Integer>();
	}

	public void topologicalSort()
	{
		this.N = this.graph.size();
		visited = new boolean[N];
		Arrays.fill(visited, false);
		for(Integer i : this.graph.keySet())
		{
			if(visited[i]==false)
				this.topologicalSortUtil(i);
		}
	}
	//generic dfs traversal + stack
	public void topologicalSortUtil(int vertex)
	{
		this.visited[vertex] = true;
		//System.out.print(vertex+"\t");
		ArrayList<Integer> adjacent = this.graph.get(vertex);
		for(int i=0;i<adjacent.size();i++)
		{
			int v = adjacent.get(i);
			if(visited[v]==false)
				topologicalSortUtil(v);
		}
		//push the vertex on the stack only when all its adjacent vertices are on stack
		stack.push(vertex);
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

  	public static void main(String args[])
  	{
  		TopologicalSort t = new TopologicalSort();
  		t.addEdge(5, 0);
  		t.addEdge(4, 0);
  		t.addEdge(5, 2);
  		t.addEdge(2, 3);
  		t.addEdge(3, 1);
  		t.addEdge(4, 1);
  		t.addEdge(1, 1);
  		t.addEdge(0, 0);
  		t.topologicalSort();
  		while(!t.stack.isEmpty())
  			System.out.print(t.stack.pop()+"\t");
  		System.out.println();
  	}
}