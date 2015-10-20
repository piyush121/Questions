class Sequence
{
    public static void findSequence(int[] a)
    {
        int count=1;
        int index=-1;
        int temp =1;
        int tempIndex = -1;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]-a[i-1]==1)
            {
                if(temp ==1)
                    tempIndex = i-1;
                temp++;
            }
            else
            {
                if(temp>count)
                {
                    count = temp;
                    index = tempIndex;
                }
                temp = 1;
                tempIndex = -1;
            }
        }
        System.out.print(index+" ");
        for(int i=0;i<count;i++)
        {
            System.out.print(a[index+i]+" ");
        }
    }

	public static void main(String args[])
	{
		int[] a = {1,4,5,6,9, 10};
		int[] b = {2, 3, 7, 9, 10, 12};
		int[] c = {0, 9, 2, 3,4, 1, 2, 3};
		Sequence.findSequence(a);
		Sequence.findSequence(b);
		Sequence.findSequence(c);
	}
}
