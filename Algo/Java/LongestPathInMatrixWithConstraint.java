/* http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/?utm_source=feedburner&utm_medium=email&utm_campaign=Feed%3A+Geeksforgeeks+%28GeeksforGeeks%29 */
import java.util.Arrays;
class LongestPathInMatrixWithConstraint
{
	public static void main(String args[])
	{
		int[][] mat = {
						{1, 2, 9},
                   		{5, 3, 8},
                   		{4, 6, 7}
                   	};
        LongestPathInMatrixWithConstraint l = new LongestPathInMatrixWithConstraint();
        int N = mat.length;
        int max = Integer.MIN_VALUE;
        for(int r=0;r<mat.length;r++)
        {
        	for(int c=0;c<mat[mat.length-1].length;c++)
        	{
        		System.out.println("--------------");
        		int length = 1;
        		length = l.findLongestPathFromPoint(r, c, length, N, mat);
        		System.out.println("length: "+length);
        		if(length>max)
        			max = length;
        	}
        }
       System.out.println(max);

       System.out.println(l.dpSolution(mat));
	}

	public int dpSolution(int[][] mat)
	{
		int[][] dp = new int[mat.length][mat.length];
		for(int i=0;i<mat.length;i++)
			Arrays.fill(dp[i], -1);
		int result = Integer.MIN_VALUE;
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat.length;j++)
			{
				if(dp[i][j]==-1)
					dp[i][j] = dpSolutionHelper(i, j, mat, dp);
				System.out.println("row: "+i+" col: "+j+" value: "+dp[i][j]);
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}

	public int dpSolutionHelper(int row, int col, int[][] mat, int[][] dp)
	{
		if(row<0||row>=mat.length||col<0||col>=mat.length)
			return 0;
		if(dp[row][col]!=-1)
			return dp[row][col];
		int N = mat.length;
		if(row+1<N && (mat[row+1][col]- mat[row][col])==1)
			return 1 + dpSolutionHelper(row+1, col, mat, dp);
		if(col+1<N && (mat[row][col+1]- mat[row][col])==1)
			return 1 + dpSolutionHelper(row, col+1, mat, dp);
		if(row-1>-1 && (mat[row-1][col]- mat[row][col])==1)
			return 1 + dpSolutionHelper(row-1, col, mat, dp);
		if(col-1>-1 && (mat[row][col-1]- mat[row][col])==1)
			return 1 + dpSolutionHelper(row, col-1, mat, dp);
		return dp[row][col] = 1;
	}

	public int findLongestPathFromPoint(int row, int col, int length, int N, int[][] mat)
	{
		//Base Case
		String move = hasMove(row, col, N, mat);
		if(!"N".equals(move))
		{
			System.out.println("row: "+row+" col: "+col+ " length: "+length+" move: "+move);
			switch(move)
			{
				case "D" : return findLongestPathFromPoint(row+1, col, length+1, N, mat);
				case "R" : return findLongestPathFromPoint(row, col+1, length+1, N, mat);
				case "U" : return findLongestPathFromPoint(row-1, col, length+1, N, mat);
				case "L": return findLongestPathFromPoint(row, col-1, length+1, N, mat);
				default: return length;
			}
		}
		return length;

	}

	public String hasMove(int row, int col, int N, int[][] mat)
	{
		if(row+1<N && (mat[row+1][col]- mat[row][col])==1)
			return "D";
		else if(col+1<N && (mat[row][col+1]- mat[row][col])==1)
			return "R";
		else if(row-1>-1 && (mat[row-1][col]- mat[row][col])==1)
			return "U";
		else if(col-1>-1 && (mat[row][col-1]- mat[row][col])==1)
			return "L";
		else
			return "N";
	}
}
