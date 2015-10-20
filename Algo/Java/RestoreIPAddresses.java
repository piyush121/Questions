import java.util.ArrayList;
import java.util.List;
public class RestoreIPAddresses
{
    public static void main(String args[])
    {
        RestoreIPAddresses r = new RestoreIPAddresses();
        String s = "25525511135";
        //System.out.println(r.restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s)
    {
        ArrayList<String> list = new ArrayList<String>();
        return helper("", "", s, list, 3, s.length());
    }

    public List<String> helper(String ip, String p, String q, ArrayList<String> lists, int count, int len)
    {
        //System.out.println("ip: " + ip);
        //System.out.println("p: " + p);
        //System.out.println("q: " + q);
        if(!p.equals("") && Integer.parseInt(p)<256)
        {
            if(ip.equals(""))
                ip = Integer.parseInt(p)+"";
            else
            {
                ip = ip + "." + Integer.parseInt(p);
                count--;
            }
        }
        if(q.equals("") && count==0 && ip.length()==len+3)
            lists.add(ip);
        if(q.length()>=1 && count>0)
            helper(ip, q.substring(0,1), q.substring(1, q.length()), lists, count, len);
        if(q.length()>=2 && count>0)
            helper(ip, q.substring(0,2), q.substring(2, q.length()), lists, count, len);
        if(q.length()>=3 && count>0)
            helper(ip, q.substring(0,3), q.substring(3, q.length()), lists, count, len);
        return lists;
    }
}
