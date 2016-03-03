/*
	two non-negative numbers are called siblings if they can be obtained 
	from each other by rearranging the digits of their decimal representations.
	for example, 123 and 213 are siblings, 535 and 355 are also siblings
*/
public class SiblingNumbers
{
	public static void main(String args[])
	{	
		SiblingNumbers s = new SiblingNumbers();
		System.out.println(s.isSibling(123, 213));
	}

	public boolean isSibling(int num1, int num2)
	{
		int[] countArray = new int[10];
		int p1 = num1;
		int p2 = num2;
		while(p1>0)
		{
			countArray[p1%10]++;
			p1 = p1/10;
		}

		while(p2>0)
		{
			countArray[p2%10]--;
			p2 = p2/10;
		}

		for(int i=0;i<10;i++)
		{
			if(countArray[i]!=0)
				return false;
		}
		return true;
	}
}

/*
	root@localhost: dwfDDayk(3sC
	
	select sensor_id, count(distinct event_type) as types
	from events
	group by sensor_id;

MapReduce 
MapReduce works by breaking the processing into two phases: the map phase and the reduce phase.
Each phase has key-value pairs as input and output, the types of which may be chosen by the
programmer.
The Map function that performs filtering and sorting and then outputs a set of records
of the form (key, data)
The Reduce function that performs a summary operation (such as counting the number 
of students in each queue, yielding name, frequencies) 


In general, there are multiple instances of the map program running on different nodes of a compute cluster. Each map instance is given a distinct portion of the input file by the MapReduce scheduler to process. 

As such, a single-threaded implementation of MapReduce will usually not be faster than a traditional (non-MapReduce) implementation, any gains are usually only seen with multi-threaded implementations

for example, a word count using MapReduce as a design Pattern

http://blog.csdn.net/xudli/article/details/40818153


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class WordCountUsingMapReduce
{
	List<String> wordList;
	List<Integer> freqList;

	Map<String, ArrayList<Integer>> intermediateMap;

	public WordCountUsingMapReduce()
	{
		this.wordList = new ArrayList<>();
		this.freqList = new ArrayList<>();
		this.intermediateMap = new HashMap<>();
	}

	public static void main(String args[])
	{
		WordCountUsingMapReduce w = new WordCountUsingMapReduce();
		try(BufferedReader br = new BufferedReader(new FileReader(new File("./test1.txt"))))
		{
			int lineCount = 1;
			String line = "";
			while((line = br.readLine())!=null)
			{
				w.mapper(lineCount, line);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		//System.out.println(w.wordList);
		//System.out.println(w.freqList);
		w.combiner();
		System.out.println(w.intermediateMap);
		w.reducer();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./output.txt"))))
		{
			for(int i=0;i<w.wordList.size();i++)
			{
				bw.write(w.wordList.get(i) + " "+ w.freqList.get(i)+"\n");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void mapper(Integer key, String value)
	{
		String[] words = value.split(" ");
		for(String word : words)
		{
			wordList.add(word);
			freqList.add(1);
		}
	}

	public void combiner()
	{
		for(int i=0;i<wordList.size();i++)
		{
			if(intermediateMap.containsKey(wordList.get(i)))
			{
				ArrayList<Integer> list = intermediateMap.get(wordList.get(i));
				list.add(freqList.get(i));
			}
			else
			{
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(1);
				intermediateMap.put(wordList.get(i), tempList);
			}
		}
	}

	public void reducer()
	{
		this.wordList = new ArrayList<>();
		this.freqList = new ArrayList<>();
		for(String word: intermediateMap.keySet())
		{
			this.wordList.add(word);
			this.freqList.add(intermediateMap.get(word).size());
		}
	}


}

*/
