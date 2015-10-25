class RobotPath
{
	private static int X_AXIS = 2;
	private static int Y_AXIS = 2;

	public static void main(String args[])
	{
		findPath(0,0,"");
	}
	//No constraints
	public static void findPath(int x, int y, String path)
	{
		if(X_AXIS<=x && Y_AXIS<=y)
		{
			System.out.println(path);
			return;
		}
		if(x<X_AXIS)
			findPath(x+1,y,path+"X");
		if(y<Y_AXIS)
			findPath(x, y+1, path+"Y");
	}
}
