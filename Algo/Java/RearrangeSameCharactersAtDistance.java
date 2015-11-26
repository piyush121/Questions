/* http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/ */

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class RearrangeSameCharactersAtDistance
{
	public String rearrange(String str, int d)
	{
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				int f = map.get(str.charAt(i));
				map.put(str.charAt(i), ++f);
			}
			else
			{
				//System.out.println(str.charAt(i));
				map.put(str.charAt(i), 1);
			}
		}
		//System.out.println(map);
		for(Map.Entry<Character, Integer> entry : map.entrySet())
		{
			pq.add(new Pair(entry.getKey(), entry.getValue()));
		}
		//System.out.println(pq);
		StringBuilder temp = new StringBuilder();
		for(int i=0;i<str.length();i++)
			temp.append("#");
		while(!pq.isEmpty())
		{
			System.out.println(temp);
			Pair p = pq.poll();
			int idx = temp.indexOf("#");
			int f = 0;
			while(f<p.freq  && idx < temp.length())
			{
				//System.out.println("idx: "+idx + " f: "+f);
				temp.setCharAt(idx, p.c);
				f++;
				idx = idx + d;
			}
		}
		return temp.toString();
	}
	public static void main(String args[])
	{
		RearrangeSameCharactersAtDistance r = new RearrangeSameCharactersAtDistance();
		String str = "aaa";
    	System.out.println(r.rearrange(str, 2));
	}
}

class Pair implements Comparable<Pair>
{
	char c;
	int freq;

	public Pair(char c, int freq)
	{
		this.c = c;
		this.freq  = freq;
	}
	@Override
	public int compareTo(Pair p)
	{
		return p.freq - this.freq;
	}

	public String toString()
	{
		return this.c + ": " + this.freq;
	}
}