class PatternMatching
{
	public static void main(String args[])
	{
		PatternMatching p = new PatternMatching();
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		p.method1(pattern, text);
	}

	public void method1(String pattern , String text)
	{
		for(int i=0;i<text.length()-pattern.length();i++)
		{
			int j;
			for(j=0;j<pattern.length();j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			if(j==pattern.length())
				System.out.println("pattern found at "+i);
		}
	}
}
