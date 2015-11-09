/* http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/ */
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

class PrimsMinimumSpanningTree
{
	public void findMST(int[][] graph)
	{
		Set<Integer> mst = new HashSet<>();
		PriorityQueue<Edge> q = new PriorityQueue<>();
		mst.add(0);
		//picking 0 as the initial vertices
		for(int i=0;i<graph[0].length; i++)
		{
			if(graph[0][i]!=0)
			{
				q.add(new Edge(0, i, graph[0][i]));
			}
		}
		Edge e = null;
		while(mst.size()!=graph.length)
		{
			e = q.poll();
			if(!mst.contains(e.u))
			{
				System.out.println(e.u+" - "+e.v+" : "+ e.weight);
				mst.add(e.u);
				for(int i=0;i<graph[e.u].length;i++)
				{
					if(graph[e.u][i]!=0 && !mst.contains(i))
					{
						q.add(new Edge(e.u, i, graph[e.u][i]));
					}
				}
			}
			else if(!mst.contains(e.v))
			{
				System.out.println(e.u+" - "+e.v+" : "+ e.weight);
				mst.add(e.v);
				for(int i=0;i<graph[e.v].length;i++)
				{
					if(graph[e.v][i]!=0 && !mst.contains(i)) 
					{
						q.add(new Edge(e.v, i, graph[e.v][i]));
					}
				}
			}
		}
	}


	public static void main(String args[])
	{
		/* int graph[][] = {
		 					{0, 2, 0, 6, 0},
                      		{2, 0, 3, 8, 5},
                      		{0, 3, 0, 0, 7},
                      		{6, 8, 0, 0, 9},
                      		{0, 5, 7, 9, 0},
                     	};
        */
        int graph[][] = {
        					{0, 4, 0, 0, 0, 0, 0, 8, 0},
                      		{4, 0, 8, 0, 0, 0, 0, 11, 0},
                      		{0, 8, 0, 7, 0, 4, 0, 0, 2},
                      		{0, 0, 7, 0, 9, 14, 0, 0, 0},
                      		{0, 0, 0, 9, 0, 10, 0, 0, 0},
                      		{0, 0, 4, 0, 10, 0, 2, 0, 0},
                      		{0, 0, 0, 14, 0, 2, 0, 1, 6},
                      		{8, 11, 0, 0, 0, 0, 1, 0, 7},
                      		{0, 0, 2, 0, 0, 0, 6, 7, 0}
                     };
        
        PrimsMinimumSpanningTree m = new PrimsMinimumSpanningTree();
        m.findMST(graph);
	}
}

class Edge implements Comparable<Edge>
{
	int weight;
	int u;
	int v;

	public Edge(int u, int v, int weight)
	{
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	public int compareTo(Edge e)
	{
		return this.weight - e.weight;
	}

	public String toString()
	{
		return this.u + " - " + this.v + " : " + this.weight;
	}
}