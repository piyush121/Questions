import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class PhoneNumbers
{
	HashMap<String, String[]> map = null;
	ArrayList<String> a = new ArrayList<String>();
	PhoneNumbers()
	{
		map = new HashMap<String, String[]>();
		map.put("1", new String[]{"."});
		map.put("2", new String[]{"A", "B", "C"});
		map.put("3", new String[]{"D", "E", "F"});
		map.put("4", new String[]{"G", "H", "I"});
		map.put("5", new String[]{"J", "K", "L"});
		map.put("6", new String[]{"M", "N", "O"});
		map.put("7", new String[]{"P", "Q", "R", "S"});
		map.put("8", new String[]{"T", "U", "V"});
		map.put("9", new String[]{"W", "X", "Y", "Z"});
		map.put("0", new String[]{" "});
	}

	public List<String> letterCombinations(String phoneNumber)
	{
		return helper(phoneNumber, "", 0, 0);
	}

	public List<String> helper(String phoneNumber, String temp, int count, int num)
	{
		if(count==phoneNumber.length())
		{
			a.add(temp);
			//System.out.println(temp);
		}
		if(num > phoneNumber.length()-1)
			return null;
		String[] s = map.get(phoneNumber.charAt(num)+"");
		for(int i=0;i<s.length;i++)
		{
			helper(phoneNumber, temp+s[i], count+1, num+1);
		}
		return a;
	}

	public static void main(String args[])
	{
		PhoneNumbers ph = new PhoneNumbers();
		System.out.println(ph.letterCombinations("72926"));
	}
}
