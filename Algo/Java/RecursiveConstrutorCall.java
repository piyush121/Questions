public class RecursiveConstrutorCall
{
	//compile time error: recursive constructor invocation
	public RecursiveConstrutorCall(int a)
	{
		this();
	}

	public RecursiveConstrutorCall()
	{
		this(1);
	}
}	