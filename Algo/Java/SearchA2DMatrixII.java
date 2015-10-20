/* https://leetcode.com/problems/search-a-2d-matrix-ii/ */
public class SearchA2DMatrixII
{
    public static void main(String args[])
    {
        SearchA2DMatrixII s = new SearchA2DMatrixII();
        int[][] matrix = {
                            {1,   4,  7, 11, 15},
                            {2,   5,  8, 12, 19},
                            {3,   6,  9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}
                        };
        System.out.println(s.searchMatrix(matrix, 25));
    }

    public boolean searchMatrix(int[][] matrix, int target)
    {
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>-1)
        {
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col] > target)
                col--;
            else if(matrix[row][col] < target)
                row++;
        }
        return false;
    }
}
