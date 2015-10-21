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
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.security.*;
import java.security.*;
import java.math.*;

class Challenge
{
    
    private Set<String> setOfWords;
    private Set<Character> setOfCharacter;
    private Map<Character, Integer> characterCountMap;

    public Challenge(String text)
    {
        this.setOfWords = new HashSet<>();
        this.setOfCharacter = new HashSet<>();
        for(int i=0; i<text.length();i++)
        {
            this.setOfCharacter.add(text.charAt(i));
        }
        characterCountMap = createHashMap(text);
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

    public Map<Character, Integer> createHashMap(String str)
    {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (int i=0; i<str.length();i++)
        {
            if(str.charAt(i)==' '){
                continue;
            }
            if(characterCountMap.containsKey(str.charAt(i)))
            {
                characterCountMap.put(str.charAt(i),characterCountMap.get(str.charAt(i))+1);
            }
            else
            {
                characterCountMap.put(str.charAt(i),1);
            }
        }
        return characterCountMap;
    }


    boolean isValidHashMap(String word)
    {
        //System.out.println("word:" + word);
        Map<Character, Integer> countMap = createHashMap(word);
        if(countMap.size()>this.characterCountMap.size())
        {
            return false;
        }
        for(char a:this.characterCountMap.keySet())
        {
            if(countMap.containsKey(a))
            {
                if(countMap.get(a)>this.characterCountMap.get(a))
                {
                    return false;
                }
            }
        }
        return true;
    }

    void filterSet()
    {
        Set<String> temp = new HashSet<>();
        for(String word:setOfWords)
        {
            
            if(this.isValidHashMap(word))
            {
                temp.add(word);
            }
        }
        setOfWords.clear();
        setOfWords.addAll(temp);
    }

    public void findPermutation()
    {

    }

    public void findPermutationHelper(String combine) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        for(String s : setOfWords)
        {
            if(s.length()==1  && !s.equals("a") && !s.equals("i")){
                continue;
            }
            if(s.length()==2  && !s.equals("of") && !s.equals("to") && !s.equals("am") && !s.equals("go") && !s.equals("do")){
                continue;
            }
            combine = combine+" "+s;
            if(combine.replaceAll(" ","").length() < 15)
            {
                if(this.isValidHashMap(combine))
                    findPermutationHelper(combine);
            }
            if(combine.replaceAll(" ","").length()==15)
            {
                if(this.isValidHashMap(combine)){
                    System.out.println(combine);
                    if("d5e847370c4d30b7e7aa8441a8b1303d".equals(this.getMD5(combine)))
                    {
                        System.out.println("Answer:"+combine);
                        System.exit(0);
                    }
                }
            }
                combine = combine.substring(0,combine.length()-s.length()-1);
        }
    }

    public String getMD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {       
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(text.getBytes(),0,text.length());
        return new BigInteger(1,m.digest()).toString(16);
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, UnsupportedEncodingException
    {
        Challenge c = new Challenge("forager dog motto");
        c.filterWords();
        System.out.println(c.setOfWords.size());
        c.filterSet();
        System.out.println(c.setOfWords.size());
        c.findPermutationHelper("");
    }
}

