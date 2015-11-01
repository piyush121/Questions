class Permutation
{
	public static void permute(String prefix, String str)
	{
		//base case
		int n = str.length();
		if(n==0)
			System.out.println(prefix);
		else
		{
			for(int i=0;i<n;i++)
			{
				permute(prefix + str.charAt(i), str.substring(0,i)+str.substring(i+1));
			}
		}
	}

	public List<List<Integer>> permute(int[] nums) 
	{
        
    }

	public static void main(String[] args)
	{
		Permutation.permute("", "ABCD");
	}
}
