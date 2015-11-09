/* http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/ */
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;

public class DijkstrasShortestPath
{
	public int[] findShortestPath(int[][] graph, int src)
	{
		int[] spt = new int[graph.length];
		Arrays.fill(spt, Integer.MAX_VALUE);
		spt[src] = 0;

		PriorityQueue<Edge> p = new PriorityQueue<>();
		for(int i=0;i<graph[src].length;i++)
		{
			if(graph[src][i]!=0)
			{
				p.add(new Edge(src, i, graph[src][i]));
				spt[i] = graph[src][i];
			}
		}

		Set<Integer> processed = new HashSet<>();
		processed.add(src);
		helper(graph, spt, p, processed);
		return spt;
	}

	public void helper(int[][] graph, int[] spt, PriorityQueue<Edge> p, Set<Integer> processed)
	{
		while(processed.size()!=spt.length)
		{
			//System.out.println(p);
			Edge e = p.poll();
			//System.out.println("Edge: "+e);
			if(!processed.contains(e.v))
			{
				processed.add(e.v);
				//System.out.println("v: "+e.v+ " cost v: " + spt[e.v] + " cost: "+spt[e.u] + " weight "+e.weight);
				System.out.println(e.v + " : "+spt[e.v]);
				for(int i=0;i<graph[e.v].length;i++)
				{
					if(graph[e.v][i]!=0 && !processed.contains(i))
					{
						p.add(new Edge(e.v, i, graph[e.v][i]));
						spt[i] = Math.min(spt[i], spt[e.v] + graph[e.v][i]);
					}	
				}
			}
		}
		for(int i=0;i<spt.length;i++)
		{
			System.out.println(i+": "+ spt[i]);
		}
	}

	public static void main(String args[])
	{
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
        DijkstrasShortestPath d = new DijkstrasShortestPath();
        d.findShortestPath(graph, 0);
	}
}

class Edge implements Comparable<Edge>
{
	int u;
	int v;
	int weight;

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
