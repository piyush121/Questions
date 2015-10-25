import java.util.Arrays;
class LargestNumber
{
	public static void main(String args[])
	{
		String[] s = {"30", "3", "34","600", "5", "9"};
		Arrays.sort(s);
		for(String q: s)
		{
			System.out.print(q+"\t");
		}
	}
}
