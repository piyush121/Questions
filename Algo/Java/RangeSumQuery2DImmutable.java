/*https://leetcode.com/problems/range-sum-query-2d-immutable/*/
class RangeSumQuery2DImmutable
{
	int[][] sumMatrix;

	public RangeSumQuery2DImmutable(int[][] matrix) 
	{
		if(matrix==null || matrix.length==0)
			return;
        this.sumMatrix = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;++i)
        {
        	sumMatrix[i][0] = matrix[i][0];
        	for(int j=1;j<matrix[i].length;++j)
        	{
        		sumMatrix[i][j] =  sumMatrix[i][j-1]+ matrix[i][j];
        	}
        }

        for(int i=0;i<sumMatrix.length;i++)
        {
        	for(int j=0;j<sumMatrix[i].length;j++)
        	{
        		System.out.print(sumMatrix[i][j]+" ");
        	}
        	System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) 
    {
       	int sum = 0;
       	for(int i=row1; i<=row2;++i)
       	{

       		if(col1==0)
        		sum = sum + this.sumMatrix[i][col2];
        	else 
        		sum = sum + this.sumMatrix[i][col2]-this.sumMatrix[i][col1-1];
       	}
       	return sum;
    }

    public static void main(String arrgs[])
    {
    	
    	int[][] matrix = {
  							{3, 0, 1, 4, 2},
							{5, 6, 3, 2, 1},
  							{1, 2, 0, 1, 5},
  							{4, 1, 0, 1, 7},
 							{1, 0, 3, 0, 5}
						};
		RangeSumQuery2DImmutable r = new RangeSumQuery2DImmutable(matrix);
		System.out.println(r.sumRegion(2, 1, 4, 3));
		System.out.println(r.sumRegion(1, 1, 2, 2));
		System.out.println(r.sumRegion(1, 2, 2, 4));
		System.out.println(r.sumRegion(0, 1, 2, 3));
		System.out.println(r.sumRegion(1, 2, 3, 4));
    }
}