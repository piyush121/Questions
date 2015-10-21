import java.util.Random;
class RandomDice
{
	public static void main(String args[])
	{
		double sum =0;
		for(int i=0;i<10000;i++)
		{
			sum = sum +randomInteger(1,6);
		}
		System.out.println(sum/10000);
	}

	public static int randomInteger(int min, int max)
	{

		Random rand = new Random();
		// nextInt excludes the top value so we have to add 1 to include the top value
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}
