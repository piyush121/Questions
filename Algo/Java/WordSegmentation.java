/* http://www.phontron.com/teaching.php */
/* http://www.phontron.com/slides/nlp-programming-en-03-ws.pdf */

/* Word Segmentation using viterbi algorithm */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class WordSegmentation
{
	Map<Integer, Double> bestScore;
	Map<Integer, Integer> bestEdge;
	Map<String, Double> probabilityMap;

	public WordSegmentation()
	{
		this.bestScore = new HashMap<>();
		this.bestEdge = new HashMap<>();
		this.probabilityMap = new HashMap<>();
		//given the probability of occuring different constructs
		//for example, ("ab", 0.246596964) means probability of occuring 
		//ab is 0.246596964
		probabilityMap.put("a", 0.0907179533);
		probabilityMap.put("b", 0.0183156389);
		probabilityMap.put("c", 0.100258844);
		probabilityMap.put("ab", 0.246596964);
		probabilityMap.put("bc", 0.122456428);
	}
	//call this method for each line of input
	public void segment(String line)
	{
		//Forward Step
		this.bestScore.put(0, 0.0);
		this.bestEdge.put(0, -1);
		for(int wordEnd=1;wordEnd<line.length()+1;++wordEnd)
		{
			this.bestScore.put(wordEnd, Double.MAX_VALUE);
			for(int wordBegin=0;wordBegin<wordEnd;++wordBegin)
			{
				String word = line.substring(wordBegin, wordEnd);
				if(probabilityMap.containsKey(word) || word.length()==1)
				{ 
					double prob = probabilityMap.get(word);
					double score = bestScore.get(wordBegin) + (- Math.log(prob));
					if(score < bestScore.get(wordEnd))
					{
						//System.out.println("score: "+ score+ " wordBegin: "+wordBegin+ " wordEnd: "+wordEnd);
						bestScore.put(wordEnd, score);
						bestEdge.put(wordEnd, wordBegin);
					}
				}
			}
		}
		//backward step
		Stack<String> words = new Stack<>();
		int nextEdge = bestEdge.get(bestEdge.size()-1);
		words.push(line.substring(nextEdge, bestEdge.size()-1));
		
		while(bestEdge.get(nextEdge)!=-1)
		{
			String s = line.substring(bestEdge.get(nextEdge), nextEdge);
			words.push(s);
			nextEdge = bestEdge.get(nextEdge);
		}
		
		while(!words.isEmpty())
		{
			System.out.print(words.pop()+" ");
		}
		System.out.println();
	}

	public static void main(String args[])
	{
		WordSegmentation w = new WordSegmentation();
		w.segment("abc");
		w.segment("bbc");
	}
}