public class Test1
{
	//compile time error: Test1() has private access in Test1
	private Test1()
	{
		System.out.println("Test1");
	}
}

class Test2 extends Test1
{
	public Test2()
	{
		System.out.println("Test2");
	}
}