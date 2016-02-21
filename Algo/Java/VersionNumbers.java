/* https://leetcode.com/problems/compare-version-numbers/ */
class VersionNumbers
{
	public int compareVersion(String version1, String version2)
	{
		//split the two strings on "."
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i=0;
		int j=0;
		//get the length of the arrays
		int m = v1.length;
		int n = v2.length;
		while(i<m && j<n)
		{
			//compare v1[i] with v2[i]
			if(Integer.parseInt(v1[i]) 	> Integer.parseInt(v2[i]))
				return 1;
			else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i]))
				return -1;
			i++;
			j++;
		}
		//check the remaining elements in the array (if any)
		for(;i<m;i++)
			if(Integer.parseInt(v1[i]) 	> 0)
				return 1;
		for(;j<n;j++)
			if(Integer.parseInt(v2[j]) 	> 0)
				return -1;
		return 0;
    }

	public static void main(String args[])
	{
		VersionNumbers vn = new VersionNumbers();
		vn.compareVersion("1", "1.1");
	}
}
