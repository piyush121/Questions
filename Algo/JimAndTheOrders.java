/*https://www.hackerrank.com/challenges/jim-and-the-orders*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        //int res;
        Solution solution = new Solution();
        int size = 0;
        size = Integer.parseInt(in.nextLine());
        List<Order> pq = new ArrayList<>();
        for(int i = 0; i < size; i++)
        {
            try
            {
                String[] temp = in.nextLine().split(" ");
                pq.add(solution.new Order( i+1, Integer.parseInt(temp[0]) ,Integer.parseInt(temp[1])));
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }

        Collections.sort(pq, solution.new Order(0,0,0));
        solution.processOrders(pq);
        //bw.write(String.valueOf(res));
        //bw.newLine();
        //bw.close();
    }

    class Order implements Comparator<Order>
    {
        int orderNo;
        int arrivalTime;
        int processingTime;

        Order(int orderNo, int arrivalTime, int processingTime)
        {
            this.orderNo = orderNo;
            this.arrivalTime = arrivalTime;
            this.processingTime = processingTime;
        }

        @Override
        public int compare(Order o1, Order o2)
        {
            int result = Integer.compare(o1.arrivalTime, o2.arrivalTime);
            if (result == 0)
            {
                result = Integer.compare(o1.orderNo, o2.orderNo);
            }
            return result;
        }
    }

    class ProcessedOrder implements Comparator<ProcessedOrder>
    {
        int orderNo;
        int processedTime;

        ProcessedOrder(int orderNo, int processedTime)
        {
            this.orderNo = orderNo;
            this.processedTime = processedTime;
        }

        @Override
        public int compare(ProcessedOrder o1, ProcessedOrder o2)
        {
            int result = Integer.compare(o1.processedTime, o2.processedTime);
            if(result==0)
            {
                result = Integer.compare(o1.orderNo, o2.orderNo);
            }
            return result;
        }
    }

    void processOrders(List<Order> pq)
    {
        List<ProcessedOrder> p = new ArrayList<>();
        for(Order order : pq)
        {
            p.add(new ProcessedOrder(order.orderNo, order.arrivalTime+order.processingTime));
        }
        Collections.sort(p, new ProcessedOrder(0,0));
        for(ProcessedOrder po : p)
        {
            System.out.print(po.orderNo+" ");
        }
    }
}
