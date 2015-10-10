// import java.util.Map;
// import java.util.List;
// import java.util.HashMap;
// import java.util.ArrayList;
import java.util.*;

class Graph
{

  Map<Integer, ArrayList<Integer>> graph;
  boolean[] visited;

  public Graph()
  {
    this.graph = new HashMap<Integer,ArrayList<Integer>>();
  }

  public void addEdge(int a, int b)
  {
    if(graph.get(a) != null)
    {
      graph.get(a).add(b);
      return;
    }
    ArrayList<Integer> edges = new ArrayList<>();
    edges.add(b);
    graph.put(a, edges);
  }

  public void isCyclic()
  {
    int N = this.graph.size();
    this.visited = new boolean[N];

    for(Integer vertex : this.graph.keySet())
    {
      System.out.print("Has cycle starting from "+vertex+" : ");
      if(visited[vertex]==false)
      {
        Stack<Integer> stack = new Stack<>();
        System.out.print(this.isCyclicUtil(vertex, stack));
      }
      System.out.println();
    }
  }

  public boolean isCyclicUtil(int vertex, Stack<Integer> stack)
  {
    this.visited[vertex] = true;
    stack.add(push);
    ArrayList<Integer> adjacency = this.graph.get(vertex);
    for(int i=0;i<adjacency.size();i++)
    {
        int v = adjacency.get(i);
        if(stack.search(v)==-1)
        {
          if(this.visited[v] == false)
            return this.isCyclicUtil(v, set);
        }
        else
        else 
          return true;
    }
    return false;
  }

  public static void main(String[] args){
    Graph g = new Graph();
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(2,3);
    g.addEdge(3,6);
    g.addEdge(1,3);
    g.addEdge(4,4);
    g.addEdge(5,5);
    g.addEdge(6,6);
    // g.addEdge(6,0);
    g.isCyclic();
  }
}
