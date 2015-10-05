import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
class ListAnagrams
{
	public List<String> anagrams(String[] strs)
	{
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> p = new ArrayList<String>();
		for(String str:strs)
		{
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String s = new String(c);
			System.out.println(s);
			if(map.containsKey(s))
			{
				System.out.println("hello");
				ArrayList<String> l = map.get(s);
				l.add(str);
				map.put(s, l);
			}
			else
			{
				ArrayList<String> l = new ArrayList<String>();
				l.add(str);
				map.put(s, l);
			}
		}
		Set<String> set = map.keySet();
		for(String key : set)
		{
			ArrayList<String> values = map.get(key);
			if(values.size()>1)
			{
				p.addAll(values);
			}
		}
		return p;
    }

	public static void main(String args[])
	{
		ListAnagrams la = new ListAnagrams();
		String[] strs = {"",""};
		System.out.println(la.anagrams(strs));
	}
}
