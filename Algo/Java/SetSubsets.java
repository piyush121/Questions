import java.util.ArrayList;
class SetSubsets
{
	public static void main(String args[])
	{
		ArrayList<Integer> set = new ArrayList();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		findSubsets(set);
	}

	public static void findSubsets(ArrayList<Integer> set)
	{
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int numSubsets = (int)Math.pow(2, set.size()) - 1;
		while(numSubsets != -1)
		{
			int temp = numSubsets;
			ArrayList<Integer> subsets = new ArrayList<Integer>();
			for(int i=0;i<set.size();i++)
			{
				if((temp & 1)==1)
					subsets.add(set.get(i));
				temp >>= 1;
			}
			allSubsets.add(subsets);
			numSubsets--;
		}
		System.out.println(allSubsets);
	}
}
