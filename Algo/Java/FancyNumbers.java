/* http://www.geeksforgeeks.org/check-if-a-given-number-is-fancy/ */
import java.util.Map;
import java.util.HashMap;
class FancyNumbers
{
	public boolean isFancy(String num)
	{
		Map<Character, Character> fancyMap = new HashMap<>();
		fancyMap.put('6', '9');
		fancyMap.put('9', '6');
		fancyMap.put('0', '0');
		fancyMap.put('1', '1');
		fancyMap.put('8', '8');

		int lo = 0;
		int hi = num.length()-1;
		while(hi>=lo)
		{
			if(fancyMap.get(num.charAt(lo))==null || fancyMap.get(num.charAt(lo))!=num.charAt(hi))
			{
				return false;
			}
			++lo;
			--hi;
		}
		return true;
	}

	public static void main(String args[])
	{
		FancyNumbers f = new FancyNumbers();
		System.out.println(f.isFancy("121"));
	}
}