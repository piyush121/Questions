/* balance by linking small tree below large one*/
class WeightedQuickUnion
{
	private static int[] id;
	private static int[] size;
	private int N;
	
	WeightedQuickUnion(int N)
	{
		this.N = N;
		id = int[N];
		sz = int[N];
		for(int i=0;i<N;i++)
		{
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int p)
	{
		while(id[i]!=i)
		{
			i = id[i];
		}
		return i;
	}
	
	public boolean find(int p, int q)
	{
		return root(p) == root(q); 
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if(sz[i]<sz[j])
		{
			id[i] = j;
			sz[j] += sz[i];
		}
		else
		{
			id[j] = i;
			sz[i] += sz[j];
		}
	}
}