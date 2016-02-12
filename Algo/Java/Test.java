import java.util.*;
import java.math.BigInteger;
class Test
{
	public static void main(String[] args)
	{
		String[] v  = "1".split(".");
		System.out.println(v.length);
		List<List<Integer>> l = new ArrayList<List<Integer>>();

		System.out.println("=====================");
		int nine = 9;
		System.out.println(Integer.bitCount(nine));
		System.out.println(Integer.toBinaryString(nine));
		int nine_1 = 9-1;
		System.out.println(Integer.toBinaryString(nine & nine_1));
		int three = 3;
		int four = 4;
		System.out.println(Integer.toBinaryString(three & four));

		System.out.println(Math.log10(1001));
		System.out.println(1%1);
		System.out.println("=====================");
		for(char i='1';i<='9';i++)
		{
			System.out.println(i);
			if('9'==i)
				System.out.println(true);
		}

		String s = "Payam      Rastogi";
		String[] arr = s.split("\\s+");
		for(String p: arr)
			System.out.println("#" +p);

		BigInteger m = new BigInteger("590");
		BigInteger e = new BigInteger("187");
		BigInteger p = new BigInteger("29");
		BigInteger q = new BigInteger("37");
		BigInteger pq = p.multiply(q);
		System.out.println(pq);
		System.out.println(m.modPow(e, pq));
	}
}
