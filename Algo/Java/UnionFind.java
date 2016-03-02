class UnionFind
{
	//number of elements in all sets
	private int N;
	//to store the parent id of the given element
	int[] id;

	//initialize
	UnionFind(int N)
	{
		this.N = N;
		id = new int[N];
		//initially the parent of the node will be the node itself
		for(int i=0;i<N;i++)
		{
			id[i] = i;
		}
	}

	//union
	public void union(int p, int q)
	{
		//get the parent id of p
		int pid = id[p];
		//for each element whose parent id is equal to parent id of p
		//change it's parent id to parent id of q
		for(int i=0;i<N;i++)
		{
			if(id[i]==pid)
				id[i] = id[q];
		}
	}

	public boolean find(int p, int q)
	{
		//check if both the elements p and q are in same set
		// hence the parent id of both nodes will be equal 
		return id[p]==id[q];
	}
}
