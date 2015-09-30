class ReverseBits
{
	public int reverseBits(int n) 
	{	
		int l=0;
		//String s ="";
		for(int i=0;i<32;i++)
		{
			l = l*2+(n & 1);
			//s = s+(n&1);
			n = n >>> 1;
			//System.out.println(s);
		}
		
		return l;
    }
	
	public static void main(String args[])
	{
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits(43261596));
	}
	
}