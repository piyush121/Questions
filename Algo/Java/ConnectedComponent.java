/* Finding Connected Components in an undirected graph using union find */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

class ConnectedComponent
{
	private Graph g;
	private int[] parent;

	ConnectedComponent(int size)
	{
		this.g = new Graph(size);
		this.parent = new int[size];
		for(int i=0;i<size;i++)
			parent[i] = i;
	}

	public HashMap<Integer, ArrayList<Integer>> findConnectedComponent()
	{
		for(int i=0;i<g.vertices;i++)
		{
			for(int v : g.adj.get(i))
			{
				if(!find(i, v))
					union(i, v);
			}
		}
		HashMap<Integer, ArrayList<Integer>> components  = new HashMap<>();
		for(int i=0;i<parent.length;i++)
		{
			if(components.containsKey(parent[i]))
			{
				components.get(parent[i]).add(i);
			}
			else
			{
				ArrayList<Integer> a = new ArrayList<>();
				a.add(i);
				components.put(parent[i],a);
			}
		}
		return components;
	}

	public void union(int p, int q)
	{
		if(!find(p, q))
		{
			int rootP = root(p);
			int rootQ = root(q);
			parent[rootQ] = rootP;
		}
	}

	public int root(int p)
	{
		while(p != parent[p])
		{
			p = parent[p];
		}
		return p;
	}

	public boolean find(int p, int q)
	{
		if(root(p) == root(q))
			return true;
		return false;
	}

	public static void main(String args[])
	{
		ConnectedComponent c = new ConnectedComponent(9);

		c.g.addEdge(1, 3);
		c.g.addEdge(1, 2);
		c.g.addEdge(3, 4);

		c.g.addEdge(5, 6);
		c.g.addEdge(7, 8);

		System.out.println(c.findConnectedComponent());
	}
}


class Graph
{
	int vertices;
	Map<Integer, ArrayList<Integer>> adj;

	public Graph(int vertices)
	{
		this.vertices = vertices;
		this.adj = new HashMap<>();
		for(int i=0; i<vertices; i++)
		{	
			adj.put(i, new ArrayList<Integer>());
		}
	}

	public void addEdge(int a, int b)
	{
		this.adj.get(a).add(b);
		this.adj.get(b).add(a);
	}
}