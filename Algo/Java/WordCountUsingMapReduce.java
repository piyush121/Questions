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