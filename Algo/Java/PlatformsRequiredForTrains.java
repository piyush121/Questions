/* http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/ */
import java.util.Arrays;

class PlatformsRequiredForTrains
{
	public int countPlatforms(int[] arr, int[] dep)
	{
		Arrays.sort(arr);
		Arrays.sort(dep);

		int m = 0;
		int n = 0;

		int count=0;
		int max = Integer.MIN_VALUE;
		while(m < arr.length && n < dep.length)
		{
			if(arr[m] < dep[n])
			{
				count++;
				m++;
				if(count > max)
					max = count;
			}
			else if(arr[m] > dep[n])
			{
				count--;
				n++;
			}
		}
		return max;
	}

	public static void main(String args[])
	{
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
    	int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    	PlatformsRequiredForTrains p = new PlatformsRequiredForTrains();
    	System.out.println(p.countPlatforms(arr, dep));
	}

}