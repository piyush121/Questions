/* http://www.geeksforgeeks.org/recursive-functions/ */
import java.util.Stack;

class TowerOfHanoi
{
	public void solve(int n)
	{
		solveRecursively(n, "source", "auxiliary", "destination");
	}

	public void solveRecursively(int n, String src, String aux, String dst)
	{
		if(n==0)
			return;
		solveRecursively(n-1, src, dst, aux);
		System.out.println("Move disk " + n + " from "+ src +" to " + dst); 
		solveRecursively(n-1, aux, src, dst);
	}

	public static void main(String args[])
	{
		TowerOfHanoi t = new TowerOfHanoi();
		t.solve(4);
	}
}