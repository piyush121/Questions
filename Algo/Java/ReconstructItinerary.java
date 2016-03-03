import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class ReconstructItinerary
{
	public static void main(String args[])
	{
		//String tickets[][] = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		String tickets[][] = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		ReconstructItinerary r = new ReconstructItinerary();
		r.findItinerary(tickets);
	}

	public List<String> findItinerary(String[][] tickets) 
	{
		List<String> result = new ArrayList<>();
   		Map<String, ArrayList<String>> graph = new HashMap<>();
   		Map<String, Boolean> visited = new HashMap<>();
   		for(int i=0;i<tickets.length;i++)
   		{
   			String key = tickets[i][0];
   			String value = tickets[i][1];
   			if(!graph.containsKey(key))
   			{
   				graph.put(key, new ArrayList<>());
   				visited.put(key, false);
   				visited.put(value, false);
   			}
   			graph.get(key).add(value);
   		}
   		System.out.println(visited);
 		dfs("JFK", graph, visited, result);
   		System.out.println(result);
   		return result;
    }

    public void dfs(String key, Map<String, ArrayList<String>> graph, 
    	Map<String, Boolean> visited, List<String> result)
    {
    	System.out.println("key: "+ key);		
    	//if(visited.get(key)==true)
    	//	return;
    	//else
    	{
    		visited.put(key, true);
    		result.add(key);
    		ArrayList<String> adjacent = graph.get(key);
    		if(adjacent!=null)
    		{
    			for(String neighbor : adjacent)
    			{
    				dfs(neighbor, graph, visited, result);
    			}
    		}
    		else
    			return;
    	}
    }
}