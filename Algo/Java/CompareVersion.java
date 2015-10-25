class CompareVersion
{
	public static void main(String args[])
	{
		System.out.println(CompareVersion.compareVersion("1.2.1", "2.1.1"));
	}
	public static int compareVersion(String version1, String version2)
	{
		String[] v1 = version1.split(".");
		String[] v2 = version2.split(".");

		if(v1.length()!=0)
	}
}
