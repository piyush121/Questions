// import java.util.Map;
// import java.util.List;
// import java.util.HashMap;
// import java.util.ArrayList;
import java.util.*;

class Graph{

  public Map<Integer, ArrayList<Integer>> graph;

  public Graph(){
    graph = new HashMap<Integer,ArrayList<Integer>>();
  }

  public void addEdge(int a, int b){
    if(graph.get(a) != null){
      graph.get(a).add(b);
    }
    ArrayList<Integer> edges = new ArrayList<>();
    edges.add(b);
    graph.put(a, edges);
  }

  public boolean isCyclic(int startNode){
    Set<Integer> visitedNodes = new HashSet<Integer>();
    LinkedList<Integer> nodeToBeVisited = new LinkedList<Integer>();
    nodeToBeVisited.add(startNode);
    while(nodeToBeVisited.peekFirst() != null){
      Integer currentNode = nodeToBeVisited.poll();
      if(visitedNodes.contains(currentNode)){
        return true;
      }
      else{
        visitedNodes.add(currentNode);
      }
      if(this.graph.get(currentNode) != null)
        nodeToBeVisited.addAll(this.graph.get(currentNode));
    }
    return false;
  }

  public int getSize()
  {
    return this.graph.size();
  }

  public ArrayList<Integer> getAdjacentListOf(int vertex)
  {
    return this.graph.get(vertex);
  }

  public static void main(String[] args){
    Graph g = new Graph();
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(2,3);
    g.addEdge(3,6);
    g.addEdge(4,5);
    System.out.println(g.isCyclic(0));
  }
}
