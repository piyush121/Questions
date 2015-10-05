class AddBinary
{
	public String addBinary(String a, String b)
	{
        if(a==null || b==null)return null;
		String s="";
		int carry=0;
		int l1 = a.length()-1;
		int l2 = b.length()-1;
		while(l1>=0 || l2>=0 || carry!=0)
		{
			int temp = (l1>=0?Integer.parseInt(a.charAt(l1--)+""):0) + (l2>=0?Integer.parseInt(b.charAt(l2--)+""):0)+carry;
			carry = temp/2;
			s = (temp%2)+s;
		}
		return s;
    }

	public static void main(String args[])
	{
		AddBinary a = new AddBinary();
		System.out.println(a.addBinary("11", "1"));
	}
}
