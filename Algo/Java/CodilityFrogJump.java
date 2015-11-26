class CodilityFrogJump
{
	public int solution(int[] A, int X, int D)
	{
		boolean[] avlbl = new boolean[X+1];
		int currPos = 0;
		avlbl[0] = true;
		avlbl[X] = true;
		int totalTime = 0;
		for(int i=0;i<A.length;i++)
		{
			if(A[i]> currPos && (A[i]-currPos <= D))
			{
				currPos = A[i];
				if(avlbl[A[i]]==false)
					avlbl[A[i]] = true;
			}
			else if(A[i] > currPos && (avlbl[A[i]]==false))
			{
				avlbl[A[i]] = true;
			}
			currPos = canReach(currPos, avlbl, D);
			if(currPos==X)
			{
				totalTime = i;
				break;
			}
		}
		return totalTime;
	}

	public int canReach(int currPos, boolean[] avlbl, int D)
	{
		print(avlbl);
		System.out.println("before currPos: "+ currPos);

		for(int i=currPos+1;i<avlbl.length;i++)
		{
			if(avlbl[i]==true && (i-currPos)<=D)
			{
				currPos = i;
			}
		}
		System.out.println("After currPos: "+ currPos);
		return currPos;
	}

	public void print(boolean[] avlbl)
	{
		for(int i=0;i<avlbl.length;i++)
		{
			if(avlbl[i]==true)
				System.out.print("1 ");
			else
				System.out.print("0 ");
		}
		System.out.println();
	}

	public static void main(String args[])
	{
		CodilityFrogJump c = new CodilityFrogJump();
		int[] A = {5, 10, 6, 1, 2};
		int X = 13;
		int D = 5;
		//int[] A = {1,3,1,4,2,5};
		//int X = 7;
		//int D = 3;
		System.out.println(c.solution(A, X, D));
	}
}