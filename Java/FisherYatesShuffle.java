import java.util.Random;
class FisherYatesShuffle
{
	public int[] shuffle(int[] a)
	{
		Random r = new Random();
		for(int i=a.length-1;i>=0;i--)
		{
			int x = r.nextInt(i+1);
			int temp = a[i];
			a[i] = a[x];
			a[x] = temp;
		}
		return a;
	}
	
	public void printArray(int[] a)
	{
		for(int x: a)
			System.out.print(x+" ");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		int[] a = {1,2, 3, 4, 5, 6,7, 8, 9, 10};
		FisherYatesShuffle f = new FisherYatesShuffle();
		f.shuffle(a);
		f.printArray(a);
	}
}