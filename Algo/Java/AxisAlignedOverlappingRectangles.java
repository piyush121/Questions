class Point
{
	int x;
	int y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

class Rectangle
{
	Point topLeft;
	Point rightBottom;

	public Rectangle(Point topLeft, Point rightBottom)
	{
		this.topLeft = topLeft;
		this.rightBottom = rightBottom;
	}
}

public class AxisAlignedOverlappingRectangles
{
	/*
	Say you have Rect A, and Rect B. Proof is by contradiction. Any one of four conditions guarantees that no overlap can exist:

	Cond1. If A's left edge is to the right of the B's right edge, - then A is Totally to right Of B
	Cond2. If A's right edge is to the left of the B's left edge, - then A is Totally to left Of B
	Cond3. If A's top edge is below B's bottom edge, - then A is Totally below B
	Cond4. If A's bottom edge is above B's top edge, - then A is Totally above B
	So condition for Non-Overlap is

	Cond1 Or Cond2 Or Cond3 Or Cond4	
	Therefore, a sufficient condition for Overlap is the opposite (De Morgan)

	Not Cond1 And Not Cond2 And Not Cond3 And Not Cond4
	*/

	public boolean isOverlapping(Rectangle r1, Rectangle r2)
	{
		if(	r1.topLeft.x < r2.rightBottom.x //Not cond1
			&& r1.rightBottom.x > r2.topLeft.x  //Not cond2
			&& r1.topLeft.y > r2.rightBottom.y //Not cond3
			&& r1.rightBottom.y < r2.topLeft.y) //Not cond4
		{
			return true;
		}
		return false;
	}

	public static void main(String args[])
	{
		Rectangle r1 = new Rectangle(new Point(0, 10), new Point(10, 0));
		Rectangle r2 = new Rectangle(new Point(5, 5), new Point(15, 0));
		AxisAlignedOverlappingRectangles a = new AxisAlignedOverlappingRectangles();
		System.out.println(a.isOverlapping(r1, r2));
	}
}