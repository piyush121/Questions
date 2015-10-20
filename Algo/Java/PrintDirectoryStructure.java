import java.io.*;
class PrintDirectoryStructure
{
	public static void traverse(File f, String tab)
	{
		File[] files = f.listFiles();
		for(File file: files)
		{
			if(file.isDirectory())
			{
				System.out.println(tab+file.getName());
				tab = tab + " ";
				traverse(file, tab);
			}
			else
				System.out.println(tab+file.getName());

		}
	}

	public static void main(String args[])
	{
		PrintDirectoryStructure pd = new PrintDirectoryStructure();
		File file = new File("D:\\Dropbox\\Java");
		traverse(file, "");
	}

}
