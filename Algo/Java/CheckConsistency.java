/* https://www.careercup.com/question?id=5724955245281280 */
import java.util.HashMap;
import java.util.Map;
public class CheckConsistency
{
	public static void main(String args[])
	{
		CheckConsistency c = new CheckConsistency();
		String[] equalities = {"A=B", "B=C", "F=J"};
		String[] inequalities = {"A!=C"};
		System.out.println(c.isConsistent(equalities, inequalities));
		
	}

	public boolean isConsistent(String[] equalities, String[] inequalities)
	{
		MapUnionFind<String> muf = new MapUnionFind<String>();
		for(int i=0;i<equalities.length;i++)
		{
			String[] s = separate(equalities[i]);
			muf.union(s[0], s[1]);
		}

		for(int i=0;i<inequalities.length;i++)
		{
			String[] s = separate(inequalities[i]);
			String root1 = muf.find(s[0]);
			String root2 = muf.find(s[1]);
			System.out.println(root1 + " " + root2);
			if(root1.equals(root2))
				return false;
		}
		return true;
	}

	private String[] separate(String e)
	{
		String[] result = new String[2];
		if(e.contains("!="))
		{
			result = e.split("!=");
		}
		else if(e.contains("="))
		{
			result = e.split("=");
		}
		return result;
	}
}

class MapUnionFind<T>
{
	Map<T, T> parentMap;

	MapUnionFind()
	{
		this.parentMap = new HashMap<>();
	}

	public T find(T obj)
	{
		T parent = parentMap.get(obj);
		if(parent==null)
			return obj;
		parent = find(parent);
		parentMap.put(obj, parent);
		return parent;
	}

	public void union(T p, T q)
	{
		T parentP = find(p);
		T parentQ = find(q);

		if(depth(p)>depth(q))
		{
			parentMap.put(parentQ, parentP);
		}
		else
		{
			parentMap.put(parentP, parentQ);
		}
	}

	private int depth(T obj)
	{
		int count =0;
		while((obj=parentMap.get(obj))!=null)
			count++;
		return count;
	}
}