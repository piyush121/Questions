/*https://leetcode.com/problems/course-schedule/*/
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
public class CourseSchedule
{
    public static void main(String args[])
    {
        int[][] prerequisites = {{0,1},
                                {0,2},
                                {1,2}
                                };
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(3,prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        boolean[] visited = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++)
        {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        System.out.println(adjacencyList);
        for(int i=0;i<numCourses;i++)
        {
            if(dfsIterativeHasCycle(adjacencyList, new boolean[numCourses], i))
                return false;
        }
        return true;
    }

    public boolean dfsIterativeHasCycle(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int val)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(val);
        while(!stack.isEmpty())
        {
            int i = stack.pop();
            visited[i] = true;
            System.out.println("i: "+i);
            ArrayList<Integer> list = adjacencyList.get(i);
            for(int j: list)
            {
                System.out.println("j: "+ j +" "+ visited[j]);
                if(visited[j]!=true)
                    stack.push(j);
                else
                {
                    System.out.println("end with true");
                    return true;
                }
            }
        }
        System.out.println("end with false");
        return false;
    }
}
