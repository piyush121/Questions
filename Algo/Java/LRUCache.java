/* https://leetcode.com/problems/lru-cache/ */

import java.util.HashMap;
import java.util.ArrayList;

//ArrayList is performance wise faster than LinkedList
class LRUCache
{
	//to maintain the order between the elements in teh LRU cache
	ArrayList<Integer> list;
	//to check if the element is present in the cache or not
	//key = unique key for element, value = any value associated with key
	HashMap<Integer, Integer> map;
	//size of the LRU cache
	int capacity = 0;

	//intialize the cache with some capacity
	public LRUCache(int capacity)
	{
        this.list = new ArrayyList<Integer>();
		this.map = new HashMap<Integer, Integer>();
		this.capacity = capacity;
    }

    //to access the elements in cache
    public int get(int key)
	{
		// if the element is not present in the map 
		// i.e. element is not present in the cache too 
		// return -1
        if(!map.containsKey(key))
		{
			return -1;
		}
		//if the element is present in the cache 
		//remove the element from its position and add it at the end of list
		list.remove(list.indexOf(key));
		list.add(key);
		//return if element found
		return map.get(key);
    }

    // add an element in the cache
    public void set(int key, int value)
	{
		// if the element is already present in the cache
		// then remove the element from its position and add it at the end
		// of the list
		if(map.containsKey(key))
		{
			list.remove(list.indexOf(key));
			map.put(key, value);
		    list.add(key);
		}
		// if the element is not present in the cache
		else
		{
			// if the size of the list is greater than the size of cache
			// then remove the element at the head of the list
		    if(list.size()>=capacity)
		    {
			    map.remove(list.remove(0));
		    }
		    // add the element in the map and list
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
