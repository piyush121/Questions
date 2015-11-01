/* https://leetcode.com/problems/bulls-and-cows/ */
class BullsAndCows
{
	public String getHint(String secret, String guess)
	{
		int countA=0;
		int countB=0;
    	for(int i=0;i<secret.length();i++)
    	{
    		if(secret.charAt(i)==guess.charAt(i))
    		{
    			secret = secret.replaceFirst(guess.charAt(i)+"", "A");
    			guess = guess.replaceFirst(guess.charAt(i)+"", "S");
    			countA++;
    		}
    	}
    	//System.out.println(secret);
    	for(int i=0;i<secret.length();i++)
    	{
    		if(secret.contains(guess.charAt(i)+""))
    		{
    			secret = secret.replaceFirst(guess.charAt(i)+"", "B");
    			guess = guess.replaceFirst(guess.charAt(i)+"", "S");
    			countB++;
    		}
    	}
    	//System.out.println(secret);
    	return countA+"A"+countB+"B";
    }

    public static void main(String args[])
    {
    	BullsAndCows bc = new BullsAndCows();
    	System.out.println(bc.getHint("1234","0111"));//"0A1B"
    	System.out.println(bc.getHint("1807", "7810"));//1A3B
    	System.out.println(bc.getHint("11", "11"));//2A0B
    	System.out.println(bc.getHint("011", "110"));//"1A2B"
    	System.out.println(bc.getHint("1122", "1222"));//"2A1B"
    }
}