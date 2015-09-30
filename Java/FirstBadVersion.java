/* https://leetcode.com/problems/first-bad-version/ */
class FirstBadVersion
{
	public int firstBadVersion(int n) 
	{
    	int lo = 0;
    	int hi = n-1;
    	while(lo <= hi)
    	{
    		int mid = lo + (hi-lo)/2;
    		if(isBadVersion(mid))
    			hi = mid - 1;
    		else
    			lo = mid + 1;
    	}
    	return lo;
    }

    boolean isBadVersion(int version)
    {
    	int[] num = {0, 1, 1, 1, 1, 1};
    	if(num[version]==1)
    		return true;
    	return false;
    }

    public static void main(String args[])
    {
    	FirstBadVersion solution = new FirstBadVersion();
    	System.out.println(solution.firstBadVersion(6));
    }
}