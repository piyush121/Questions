import java.util.LinkedList;
class PlusOne
{
	public int[] plusOne(int[] digits)
	{
		LinkedList<Integer> a = new LinkedList<Integer>();
		int carry = 0;
		int sum = digits[digits.length-1]+1;
		if(sum%10==0)
		{
			a.addFirst(0);
			carry = 1;
		}
		else
		{
			carry =0;
			a.addFirst(sum);
		}
		for(int i=digits.length-2;i>=0;i--)
		{
			sum = digits[i] + carry;
			if(sum==10)
			{
				a.addFirst(0);
				carry = 1;
			}
			else
			{
				carry =0;
				a.addFirst(sum);
			}
		}
		if(carry==1)
			a.addFirst(1);
		int[] b = new int[a.size()];
		int i=0;
		for(int j:a)
		{
			b[i] = j;
			i++;
		}
		return b;
	}

	public static void main(String args[])
	{
		PlusOne p = new PlusOne();
		int[] digits = {1,0,0,0,0};
		int[] r = p.plusOne(digits);
		for(int i : r)
			System.out.print(i+"\t");
	}
}

/*
public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >=0; i--){
            int digit = digits[i] + 1;
            if(digit < 10){
                digits[i] = digit;
                break;
            } else {
                digits[i] = digit % 10;
            }
            if(i == 0){
                int[] oldDigits = digits;
                digits = new int[digits.length + 1];
                digits[0] = 1;
                System.arraycopy(oldDigits, 0, digits, 1, oldDigits.length);
            }
        }
        return digits;
    }
*/
