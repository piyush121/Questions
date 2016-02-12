import java.util.Arrays;
class TinyMD5
{
	public static void main(String args[])
	{
		int a0 = Integer.parseInt("1101", 2);
		int b0 = Integer.parseInt("1101", 2);
		int c0 = Integer.parseInt("1101", 2);
		int d0 = Integer.parseInt("1101", 2);

		int M = 0b01011101111011;

		int K = 0b11011011101110;

		for(int j=0;j<14;j++)
		{
			int A = a0;
			int B = b0;
			int C = c0;
			int D = d0;
			int F = -1;
			int g = -1;
			for(int i=0;i<14;i++)
			{
				if(i==0 || i==4|| i==8|| i==12)
				{
					F =  (B & C) | ((~B) & D);
					//g = i;
				}
				else if ( i==1 || i==5 || i==9 || i==13)
				{
					F = (D & B) | ((~D) & C);
					//g = (5 * i + 1)^16;
				}
				else if (i==2 || i==6 || i==10)
				{
					F = (B^C)^D;
					//g = ((3 * i)+5)^16;
				}
				else if(i==3 || i==7 || i==11)
				{
					F = C^(B | (~D));
					//g = (7 * i)^16;
				}
				int dTemp = D;
				D = C;
				C = B;
				B = (B + (~(A + F + K + M)))%16;
				A = dTemp;
			}
			a0 = a0 + A;
			b0 = b0 + B;
			c0 = c0 + C;
			d0 = d0 + D;
		}
		System.out.println(Integer.toBinaryString(a0));
		System.out.println(Integer.toBinaryString(b0));
		System.out.println(Integer.toBinaryString(c0));
		System.out.println(Integer.toBinaryString(d0));
	}
}