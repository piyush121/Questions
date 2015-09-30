/*
problem: 
trees can get tall
Find too expensive need to find root of each node
Need to find root to do union
*/

class QuickUnion
{
	private int[] id;
	private int N;
	
	QuickUnion(int N)
	{	
		this.N = N;
		id = int[N];
		for(int i=0;i<N;i++)
			id[i] = i;
	}
	
	private int root(int p);
	{
		while(id[p]!=p)
			p = id[p];
		returnn p;
	}
	
	public boolean find(int p, int q)
	{
		return root(p)==root(q);
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}