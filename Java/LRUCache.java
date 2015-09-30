import java.util.HashMap;
import java.util.ArrayList;

//ArrayList is performance wise faster than LinkedList
class LRUCache
{
	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;
	int capacity = 0;
	public LRUCache(int capacity) 
	{
        this.list = new ArrayyList<Integer>();
		this.map = new HashMap<Integer, Integer>();
		this.capacity = capacity;
    }
    
    public int get(int key) 
	{
        if(!map.containsKey(key))
		{
			return -1;
		}
		list.remove(list.indexOf(key));
		list.add(key);
		return map.get(key);
    }
    
    public void set(int key, int value) 
	{
		if(map.containsKey(key))
		{
			list.remove(list.indexOf(key));
			map.put(key, value);
		    list.add(key);
		}
		else
		{
		    if(list.size()>=capacity)
		    {
			    map.remove(list.remove(0));
		    }
		    map.put(key, value);
		    list.add(key);
		}
    }
	
	public static void main(String args[])
	{
		LRUCache lc = new LRUCache(2);

		System.out.println(lc.get(2));
		lc.set(2,6);
		System.out.println(lc.get(1));
		lc.set(1,5);
		lc.set(1,2);
		System.out.println(lc.get(1));
		System.out.println(lc.get(2));
	}
}