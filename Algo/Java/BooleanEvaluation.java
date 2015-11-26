class BooleanEvaluation
{

	//generate the number of ways parenthesizing the expression
	public void generate(String exp)
	{
		for(int i=1;i<exp.length();i+=2)
		{
			char op = exp.charAt(i);
			String leftOprnd = exp.substring(0,i);
			String rightOprnd = exp.substring(i+1);
			System.out.print("("+leftOprnd+")");
			System.out.print(op +"("+rightOprnd+")"+"\n");

			generate(leftOprnd);
			generate(rightOprnd);
		}
	}

	public static void main(String args[])
	{
		BooleanEvaluation b = new BooleanEvaluation();
		String exp = "1^0|0|1";
		b.generate(exp);
	}
}