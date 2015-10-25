class ParityBits
{
	public int getParityCount(int n, int parity)
	{
		return n==0?parity:(n%2==1?getParityCount(n>>>1,parity+1):getParityCount(n>>1, parity));
	}

	public static boolean evenParity(Integer value){
        int i =0;
        boolean result = false;

        do{
           if ((value&1) == 1){
                i++;
           }
            value = value>>1;
        }while(value == 0);

        if(i % 2 == 0){
            result = true;
        }
        return result;
    }

	int parity(int x) {
    return (x == 0) ? 0 : parity(x >>> 1) + (x & 0x1);
}

	public static void main(String args[])
	{
		ParityBits p = new ParityBits();
		System.out.println(p.getParityCount(5,0));
		System.out.println(p.evenParity(5));
		System.out.println(p.parity(5));
	}
}
