import java.util.ArrayList;
import java.util.List;
class Pascal2
{
	public List<Integer> getRow(int rowIndex)
	{
         ArrayList<Integer> l = new ArrayList<Integer>();
		if(rowIndex<0)
			return l;
		if(rowIndex == 0)
		{
			l.add(1);
			return l;
		}
		if(rowIndex == 1)
		{
			l.add(1);
			l.add(1);
			return l;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		temp.add(1);

		for(int i=2;i<rowIndex+1;i++)
		{
			l = new ArrayList<Integer>();
			l.add(1);
			for(int j=1;j<i;j++)
			{
				l.add(temp.get(j-1)+temp.get(j));
			}
			l.add(1);
			temp = l;
		}
		return l;
    }

	public static void main(String args[])
	{
		Pascal2 p = new Pascal2();
		System.out.println(p.getRow(3));
	}
}
