import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
class Valtech
{
	HashSet<String> set = new HashSet<String>();
	StringBuilder sb = new StringBuilder();
	public Valtech()
	{
		try
		{
			//Get the instance of Path
			Path path = Paths.get("wordlist");
			//opens the file to read
			BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			String s = null;

			while((s=reader.readLine())!=null)
			{
				set.add(s);	
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void findAnagram(String s)
	{
		helper("", s);
	}
	
	public void helper(String curr, String rest)
	{
		if("".equals(rest))
			System.out.println(curr);
		for(int i=0;i<rest.length();i++)
		{
			helper(curr + rest.charAt(i), rest.substring(0,i)+rest.substring(i+1));
		}
			
	}
	
	public static void main(String args[]) throws IOException
	{
		Valtech v = new Valtech();
		String s = "forager dog motto";
		v.findAnagram(s);
	}
}