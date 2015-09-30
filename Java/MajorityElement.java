import java.util.HashMap;
import java.util.Arrays;
class MajorityElement
{
	public int majority(int[] num)
	{
		if(num.length==1)
			return num[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<num.length;i++)
		{
			if(map.containsKey(num[i]))
			{
				int f = map.get(num[i]);
				if(f>num.length/2)
					return num[i];
				else
					map.put(num[i], f+1);
			}
			else
			{
				map.put(num[i], 1);
			}
		}
		return -1;
	}
	
	public int majorityElementEffecient(int[] num)
	{
		if(num.length==1)
			return num[0];
		int count = 0;
		String n = "";
		for(int i=0;i<num.length;i++)
		{
			if("".equals(n))
			{
				n = num[i]+"";
				count = count+1;
			}
			else if(n.equals(num[i]+""))
			{
				count = count+1;
			}
			else if(!n.equals(num[i]+""))
			{
				count = count-1;
			}
			if(count==0)
			{
				n = "";
			}
		}
		return count!=0?Integer.parseInt(n):-1;
	}
	
	public static void main(String args[])
	{
		MajorityElement m = new MajorityElement();
		int[] num = {-1,-1,245};
		System.out.println(m.majorityElementEffecient(num));
	}
	
	public int majorityTwoLine(int[] num)
	{
		Arrays.sort(num);
		return num[num.length/2];
	}
}