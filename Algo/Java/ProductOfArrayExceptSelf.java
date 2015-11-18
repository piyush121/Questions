/* https://leetcode.com/problems/product-of-array-except-self/ */

class ProductOfArrayExceptSelf
{
	public int[] productExceptSelf(int[] nums) 
	{
		if(nums==null || nums.length<2)
			return new int[]{0};
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        a[0] = 1;
        b[b.length-1] = 1;
        for(int i=1;i<a.length;i++)
        {
        	a[i] = a[i-1]*nums[i-1];
        }
        for(int i=b.length-2;i>=0;i--)
        {
        	b[i] = nums[i+1] * b[i+1];
        }
        for(int i=0;i<b.length;i++)
        {
        	b[i] = a[i] * b[i];
        }
        return b;
    }

    public void print(int[] result)
    {
    	for(int i: result)
			System.out.print(i+" ");
		System.out.println();
    }

	public static void main(String args[])
	{
		int[] arr = {1,2,3,4};
		ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
		int[] result = p.productExceptSelf(arr);
		p.print(result);
	}
}