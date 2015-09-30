public class ExcelSheetColumnNumber
{
    public static void main(String args[])
    {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        System.out.println(e.titleToNumber("AB"));
    }

    public int titleToNumber(String s)
    {
        String alpha = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int col=0;
        for(int i=0;i<s.length();i++)
        {
            col = col * 26 + alpha.indexOf(s.charAt(i));
            System.out.println(s.charAt(i)+ " : " + col);
        }
        return col;
    }
}
