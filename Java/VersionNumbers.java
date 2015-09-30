class VersionNumbers
{
	public int compareVersion(String version1, String version2)
	{
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i=0;
		int j=0;
		int m = v1.length;
		int n = v2.length;
		while(i<m && j<n)
		{
			if(Integer.parseInt(v1[i]) 	> Integer.parseInt(v2[i]))
				return 1;
			else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i]))
				return -1;	
			i++;
			j++;
		}
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