/* https://leetcode.com/problems/maximal-square/ */

class MaximalSquare
{
	public int maximalSquare(char[][] matrix) 
	{
		if(matrix==null || matrix.length==0)
            return 0;
        int[][] temp = new int[matrix.length][matrix[0].length];
        int max=0;
      	for(int i=0;i<matrix[0].length;++i)
      	{
      		temp[0][i] = matrix[0][i]-'0';
      		if(temp[0][i]>max)
      		    max=temp[0][i];
      	}
        for(int i=0;i<matrix.length;i++)
        {
        	temp[i][0] = matrix[i][0]-'0';
            if(temp[i][0]>max)
      		    max=temp[i][0];
        } 
        
        for(int i=1;i<matrix.length;++i)
        {
        	for(int j=1;j<matrix[i].length;++j)
        	{
        		if(matrix[i][j]=='1')
        		{
        			temp[i][j] = Math.min(Math.min(temp[i-1][j], temp[i][j-1]), temp[i-1][j-1])+1;
        			if(temp[i][j]>max)
        				max = temp[i][j];
        		}
        	}
        }

        /*for(int i=0;i<temp.length;++i)
        {
        	for(int j=0;j<temp[i].length;++j)
        		System.out.print(temp[i][j]+" ");
        	System.out.println();
        }*/
        return max*max;
    }

	public static void main(String args[])
	{
		char[][] matrix = {
							{'1','0', '1', '0', '0'},
							{'1','0', '1', '1', '1'},
							{'1','1', '1', '1', '1'},
							{'1','0', '0', '1', '0'}
						};
		MaximalSquare m = new MaximalSquare();
		System.out.println(m.maximalSquare(matrix));	
	}
}