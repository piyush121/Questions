public class MatrixSearch
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		if(matrix==null)
		{
			return false;
		}
        for(int i=0;i<matrix.length;i++)
		{
			if(target==matrix[i][matrix[i].length-1])
		    {
		        return true;
		    }
			if(target<matrix[i][matrix[i].length-1])
			{
				return binarySearch(matrix[i], 0, matrix[i].length-1, target);
			}
		}
		return false;
    }

	public boolean binarySearch(int[] row, int lo, int hi, int target)
	{
		int mid = lo +(hi-lo)/2;
		if(lo>hi)
			return false;
		//System.out.println("lo: "+lo+"hi: "+hi+"mid: "+mid);
		if(row[mid]==target)
			return true;
		if(row[mid]>target)
		{
			return binarySearch(row, lo, mid-1, target);
		}
		else if(row[mid]<target)
		{
			return binarySearch(row, mid+1, hi, target);
		}
		return false;
	}

	public static void main(String args[])
	{
		int[][] matrix = {
							{1,   3,  5,  7},
							{10, 11, 16, 20},
							{23, 30, 34, 50}
						};
		MatrixSearch ms = new MatrixSearch();
		long start = System.currentTimeMillis();
		System.out.println(ms.searchMatrix(matrix, 3));
		System.out.println(System.currentTimeMillis()-start);
	}
}
