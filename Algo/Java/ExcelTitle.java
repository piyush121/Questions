/* https://leetcode.com/submissions/detail/23096006/ */
class ExcelTitle
{
	public String convertToTitle(int n)
	{
		//map to store the alphabets map
		String map = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String s = "";
		while(n>0)
		{
			//if n mod 26 is 0
			//then append Z in the string
			//and divide n/26 and subtract 1
			if(n%26==0)
			{
				s = "Z"+s;
				n = n/26-1;
			}
			else
			{
				//get character at index n mod 26
				s = map.charAt(n%26)+s;
				n = n/26;
			}
		}
		return s;
	}

	public static void main(String args[])
	{
		ExcelTitle et = new ExcelTitle();
		int n = 780;
		System.out.println(et.convertToTitle(n));
		System.out.println(et.convertToTitle1(n));
	}

	 public String convertToTitle1(int n) {
        String s = "";
        String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            n--;
            while (!(n<0)) {
                  s = map.charAt(n%26) + s;
                  n = n/26-1;
             }

            return s;
    }
}
