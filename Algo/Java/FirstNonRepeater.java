import java.util.LinkedHashMap;
import java.util.Map;
public class FirstNonRepeater
{
	public void find(String s)
	{
		LinkedHashMap<Character, Stat> map = new LinkedHashMap<Character, Stat>();
		for(int i=0;i<s.length();i++)
		{
			if(map.containsKey(s.charAt(i)))
			{
				map.get(s.charAt(i)).incrementCount();
			}
			else
			{
				map.put(s.charAt(i), new Stat(1, i));
			}
		}
		int index=Integer.MAX_VALUE;
		for(Map.Entry<Character, Stat> entry: map.entrySet())
		{
			Character c = entry.getKey();
			Stat value = entry.getValue();
			if(value.count == 1 && value.index<index)
				index = value.index;
		}
		System.out.println(s.charAt(index));
	}

	public static void main(String args[])
	{
		FirstNonRepeater f = new FirstNonRepeater();
		f.find("GeeksforGeeks");
	}
}

class Stat
{
	int count;
	int index;

	Stat(int count, int index)
	{
		this.count = count;
		this.index = index;
	}

	public void incrementCount()
	{
		this.count++;
	}
}
