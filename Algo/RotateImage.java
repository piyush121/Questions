/* https://leetcode.com/problems/rotate-image/ */
class RotateImage
{
	public static void main(String args[])
	{
		int[][] image = {
					{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,16}
				};
		printMatrix(image);
		RotateImage solution = new RotateImage();
		solution.rotate(image);
		printMatrix(image);

	}

	public void rotate(int[][] image)
	{
		int layer = image.length/2;
		for(int j=0;j<layer;j++)
		{

			int length = image.length-1-(2*j);
			System.out.println("layer: "+j + " length: "+length);
			for(int i=0;i<length;i++)
			{
				System.out.println("i: "+i);
				int temp = image[j][i];
				//left-bottom -> left-top
				image[j][i] = image[length-i][j];
				//printMatrix(image);
				//right-bottom -> left-bottom
				image[length-i][j] = image[length][length-i];
				//printMatrix(image);
				//top-right -> right-bottom
				image[length][length-i] = image[i][length];
				//printMatrix(image);
				//top-left -> top-right
				image[i][length] = temp;
			}
			printMatrix(image);
		}
	}

	static void printMatrix(int[][] image)
	{
		for(int[] row: image)
		{
			for(int num:row)
			{
				System.out.print(num+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
