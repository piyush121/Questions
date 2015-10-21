import java.util.ArrayList;
class PermutationWithRepetitions
{
	
	public void getPermutationsWithRepetitions(String[] arr)
	{
		helper(arr, new ArrayList<String>());
	}

	public void helper(String[] arr, ArrayList<String> result)
	{
		for(int i=0;i<arr.length;i++)
		{
			result.add(arr[i]);
			if(result.size() == 3)
			{
				System.out.println(result);
			}
			else
				helper(arr, result);
			result.remove(result.size()-1);
		}
	}

	public static void main(String[] args)
	{
		String[] arr = {"a", "b", "c", "d", "e"};
		PermutationWithRepetitions p = new PermutationWithRepetitions();
		p.getPermutationsWithRepetitions(arr);
	}
}