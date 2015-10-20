import java.util.ArrayList;
import java.util.List;

public class SummaryRanges
{
  public static void main(String args[])
  {
    SummaryRanges summaryRanges = new SummaryRanges();
    int[] nums = new int[]{0,1,2,4,5,7,8};
    summaryRanges.summaryRanges(nums);
  }

  public List<String> summaryRanges(int[] nums)
  {
    List<String> list = new ArrayList<String>();
    if(nums.length==0)
      return list;
    if(nums.length==1)
    {
      list.add(nums[0]+"");
      return list;
    }
    int start = 0;
    int end = 0;
    int next = 1;
    while(start < nums.length && next < nums.length)
    {
      System.out.println(next);
      if(nums[next] - nums[end]==1)
      {
        end = next;
      }
      else if(end == start)
      {
        list.add(nums[start]+"");
        start = next;
        end = next;
      }
      else if(end != start)
      {
        list.add(nums[start]+"->"+ nums[end]);
        start = next;
        end = next;
      }
      next++;
    }
    if(start==end)
      list.add(nums[start]+"");
    else if(start!=end)
      list.add(nums[start]+"->"+ nums[end]);
    //System.out.println(list);
    return list;
  }
}
