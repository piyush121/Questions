// The following MD5 hash is an anagram of the phrase “forager dog motto”
// Can you write the code to find the phrase that generated this hash:


// d5e847370c4d30b7e7aa8441a8b1303d

// Attached is a list of words that could help you.

// NOTE: In this case an anagram is made out of meaningful english words. 
// It contains exactly the same amount of each of the word-characters, but can form more or less words than in the input. 
// So it doesn’t necessarily contain the same number of spaces.

import java.util.Set;
import java.util.HashSet;
import java.io.*;

class Challenge
{
    
    private Set<String> setOfWords;
    private Set<Character> setOfCharacter;

    public Challenge(String text)
    {
        this.setOfWords = new HashSet<>();
        this.setOfCharacter = new HashSet<>();
        for(int i=0; i<text.length();i++)
        {
            this.setOfCharacter.add(text.charAt(i));
        }
    }

    private void createCharacterSet(String str)
    {

    }

    private void filterWords() throws IOException
    {
        File file = new File("wordlist[9]");
        try(FileReader fr = new FileReader(file))
        {
            try(BufferedReader br = new BufferedReader(fr))
            {
                String line = null;
                while((line = br.readLine())!= null)
                {
                    if(charactersFound(line))
                    {
                        this.setOfWords.add(line);
                    }
                }
            }
        }
    }

    private boolean charactersFound(String line)
    {
        for(int i=0;i<line.length();i++)
        {
            if(!setOfCharacter.contains(line.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

   // private String findPermutation(String str)
    {


    }

    public static void main(String[] args) throws IOException
    {
        Challenge c = new Challenge("forager dog motto");
        c.filterWords();
        System.out.println(c.setOfWords.size());
    }
}

