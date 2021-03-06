/* http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/ */
class Boggle
{

	public void findWords(char[][] boggle, String[] dictionary)
	{
		int row = boggle.length;
		int col = boggle[boggle.length-1].length;
		for(int i =0; i<boggle.length;i++)
        {
        	for(int j=0;j<boggle[i].length;j++)
        	{
        		boolean[][] visited = new boolean[row][col];
        		findWordHelper(i, j, boggle, visited, "", dictionary);
        	}
        }
	}

	public void findWordHelper(int row, int col, char[][] boggle, boolean[][] visited, String word, String[] dictionary)
	{
		visited[row][col] = true;
		word = word + boggle[row][col];
		if(isWord(word, dictionary))
			System.out.println(word+" ");
		for(int i=row-1; i<=row+1 && i<boggle.length;i++)
		{
			for(int j=col-1;j<=col+1 && j<boggle[0].length;j++)
			{
				if(i>=0 && j>=0 && visited[i][j]!=true)
				{
					//System.out.println(word);
					findWordHelper(i, j, boggle, visited, word, dictionary);
				}
			}
		}
		visited[row][col] =  false;
		word = word.substring(0, word.length()-1);

 	}

	public boolean isWord(String s, String[] dictionary) 
	{
		for(int i=0;i<dictionary.length;i++)
		{
			if(s.equalsIgnoreCase(dictionary[i]))
				return true;
		}
		return false;
	}

	public static void main(String args[])
	{
		char boggle[][] = {
		 						{'G','I','Z'},
                         		{'U','E','K'},
                       			{'Q','S','E'}
                       		};

        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
        Boggle b = new Boggle();
        b.findWords(boggle, dictionary);
	}
}