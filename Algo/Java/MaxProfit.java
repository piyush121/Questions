class MaxProfit
{
	public static void main(String args[])
	{
		MaxProfit mp =  new MaxProfit();
		int[] prices =  {2,7,0,8,4,1,8,9,11};
		System.out.println(mp.findMaxProfit(prices));
		System.out.println(mp.maxProfit1(prices));
	}

	public int findMaxProfit(int[] prices)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int i=0;i<prices.length;i++)
		{
			if(prices[i]<min)
			{
				min = prices[i];
			}
			if(prices[i]>max)
			{
				max = prices[i];
			}
		}

		return max-min;
	}

	public int maxProfit1(int[] prices) {
    if(prices == null || prices.length < 2){
        return 0;
    }

    int profit = Integer.MIN_VALUE;
    for(int i=0; i<prices.length-1; i++){
        for(int j=0; j< prices.length; j++){
            if(profit < prices[j] - prices[i]){
                profit = prices[j] - prices[i];
            }
        }
    }
    return profit;
}
}
