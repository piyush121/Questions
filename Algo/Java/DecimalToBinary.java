import java.util.List;
import java.util.ArrayList;

class DecimalToBinary
{
	public List<Integer> toBinary(int x)
	{
		List<Integer> list = new ArrayList<>();
		while(x!=0)
		{
			list.add(0, x&1);
			x>>=1;
		}
		System.out.println(list);
		return list;
	}

	public static void main(String args[])
	{
		DecimalToBinary d = new DecimalToBinary();
		d.toBinary(6);
	}
}