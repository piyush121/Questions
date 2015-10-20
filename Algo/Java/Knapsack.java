class Knapsack
{
public static void main(String args[])
{
	int items = 3;
	int capacity = 9;
	int[] values = {5,6,3};
	int[] weights = {4,5,2};
	for(int i=0;i<weights.length;i++)
	{
		int minIdx = -1;
		int minWt = Integer.MAX_VALUE;
		for(int j=i;j<weights.length;j++)
		{
			if(weights[j] < minWt)
			{
				minIdx = j;
				minWt = weights[j];
			}
		}

		//swap weights
		int tempWt = weights[minIdx];
		weights[minIdx] = weights[i];
		weights[i] = tempWt;
		//swap value
		int tempVal = values[minIdx];
		values[minIdx] = values[i];
		values[i] = tempVal;
	}
	for(int i=0;i<values.length;i++)
	{
		System.out.println("values"+values[i]+" weights"+weights[i]);
	}
	Knapsack.dpKnapsack(items, capacity, values,weights);
}
public static void dpKnapsack(int items, int capacity, int[] values,int[] weights)
{
  //sort weights and arrange values correspondingly
  int[] taken = new int[items];
  int value = 0;

  int[][] dpTable = new int[capacity + 1][items + 1];
  for (int i = 0; i <= items; i++)
  {
	for (int c = 0; c <= capacity; c++)
	{
		if (i == 0 || c == 0)
		{
			dpTable[c][i] = 0;
		}
		else
		{
			if (c - weights[i - 1] < 0)
			{
				dpTable[c][i] = dpTable[c][i - 1];
			}
			else
			{
				int isNotTaken = dpTable[c][i - 1];
				int isTaken = 0;
				if (c - weights[i - 1] >= 0)
				{
					isTaken = values[i - 1]+ dpTable[c - weights[i - 1]][i - 1];
				}
				dpTable[c][i] = Math.max(isNotTaken, isTaken);
			}
		}
	}
  }
  value = dpTable[capacity][items];

	// backtrack
	int c = capacity;
	for (int i = items; i >= 1; i--)
	{
		if (dpTable[c][i] == dpTable[c][i - 1])
		{
			taken[i - 1] = 0;
		}
		else
		{
			taken[i - 1] = 1;
			c = c - weights[i - 1];
		}
	}

	// prepare the solution in the specified output format
	System.out.println(value + " 0");
	for (int i = 0; i < items; i++)
	{
		System.out.print(taken[i] + " ");
	}
	System.out.println("");
	}
 }
