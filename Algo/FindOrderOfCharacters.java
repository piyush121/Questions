/* http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/ */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class FindOrderOfCharacters
{
	Map<Character, ArrayList<Character>> graph;
	Set<Character> seen;
	Stack<Character> stack;

	public FindOrderOfCharacters()
	{
		this.graph = new HashMap<>();
		this.stack = new Stack<>();
		this.seen = new HashSet<>();
	}

	public void processPairs(String s1, String s2)
	{
		int i=0;
		while(i<s1.length())
		{
			if(s1.charAt(i)!=s2.charAt(i))
			{
				this.addEdge(s1.charAt(i), s2.charAt(i));
				break;
			}
			i++;
		}
	}

	public void addEdge(Character from, Character to)
	{
		System.out.println("from: "+ from + " to: "+ to);
		if(this.graph.containsKey(from))
		{
			this.graph.get(from).add(to);
		}
		else
		{
			ArrayList<Character> adjacencyList = new ArrayList<>();
			adjacencyList.add(to);
			this.graph.put(from, adjacencyList);
		}
	}

	public void topologicalSort()
	{
		int N = this.graph.size();
		for(Character vertex : this.graph.keySet())
		{
			if(!seen.contains(vertex))
				topologicalSortUtil(vertex);
		}
	}

	public void topologicalSortUtil(Character vertex)
	{
		this.seen.add(vertex);
		ArrayList<Character> adjacencyList = this.graph.get(vertex);
		for(int i=0;i<adjacencyList.size();i++)
		{
			Character v = adjacencyList.get(i);
			if(!this.seen.contains(v))
				topologicalSortUtil(v);
		}
		this.stack.push(vertex);
	}

	public static void main(String args[])
	{
		FindOrderOfCharacters f = new FindOrderOfCharacters();
		String[] words = {"baa", "abcd", "abca", "cab", "cad"};
		//consider each adjacent pair
		for(int i=0;i<words.length-1;i++)
		{
			f.processPairs(words[i], words[i+1]);
		}
		f.addEdge('c', 'c');
		//System.out.println(f.graph);
		f.topologicalSort();
		while(!f.stack.isEmpty())
		{
			System.out.print(f.stack.pop()+"\t");
		}
	}

}