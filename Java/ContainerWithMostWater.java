/*https://leetcode.com/problems/container-with-most-water/*/

public class ContainerWithMostWater
{
    public static void main(String args[])
    {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] height = {4, 3 , 2, 1};
        System.out.println(c.maxArea(height));
    }

    public int maxArea(int[] height)
    {
        int p1 = 0;
        int p2 = height.length-1;
        int maxArea = 0;
        while(p1<p2)
        {
            int area = (p2-p1) * Math.min(height[p1], height[p2]);
            if(area > maxArea)
                maxArea = area;
            if(height[p1]<=height[p2])
                p1++;
            else if(height[p2]<height[p1])
                p2--;
        }
        return maxArea;
    }
}
