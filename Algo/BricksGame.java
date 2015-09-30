/* https://www.hackerrank.com/challenges/play-game */
import java.util.*;

class BricksGame
{
    public static void main(String args[])
    {
        BricksGame solution = new BricksGame();
        /*
        Scanner in = new Scanner(System.in);

        int testCases;
        testCases = in.nextInt();
        for(int i=0;i<testCases;i++)
        {
            int bricks = in.nextInt();
            int[] stack = new int[bricks];
            for(int j=0;j<bricks;j++)
            {
                stack[i] = in.nextInt();
            }
            int result;
            result = solution.playGame(stack);
            System.out.println(result);
        }
        */
        //int[] stack = {999, 1, 1, 1, 0};
        int[] stack = {0, 1 , 1, 1, 999};
        System.out.println(solution.playGame(stack));
    }

    int playGame(int[] stack)
    {
        return player1(0, 0, 0, stack, 0);
    }

    int player1(int score1, int score2, int pos, int[] stack, int max)
    {
        System.out.println("score1: "+score1+"\t score2: "+score2 +"\t pos: "+pos);
        if(pos>=stack.length)
        {
            if(score1>max)
                max = score1;
            System.out.println("Game Over" + "\t max:" +max);
            return max;
        }
        if(pos<=stack.length-1)
        {
            System.out.println("Player1 picked 1 brick: "+stack[pos]);
            max = player2(score1 + stack[pos], score2, pos+1, stack, max);
        }
        if(pos+1<=stack.length-1)
        {
            System.out.println("Player1 picked 2 bricks: " + stack[pos] + " & " +stack[pos+1]);
            max = player2(score1 + stack[pos] + stack[pos+1], score2, pos+2, stack, max);
        }
        if(pos+2<=stack.length-1)
        {
            System.out.println("Player1 picked 3 bricks: " + stack[pos] + " & " +stack[pos+1]+ " & " + stack[pos+2]);
            max = player2(score1 + stack[pos] + stack[pos+1] + stack[pos+2], score2, pos+3, stack, max);
        }
        return max;
    }

    int player2(int score1, int score2, int pos, int[] stack, int max)
    {
        System.out.println("score1: "+score1+"\t score2: "+score2 +"\t pos: "+pos);
        if(pos>=stack.length)
        {
            if(score1 > max)
                max = score1;
            System.out.println("Game Over" + "\t max:" +max);
            return max;
        }
        if(pos<=stack.length-1)
        {
            System.out.println("Player2 picked 1 brick: "+stack[pos]);
            max = player1(score1, score2+stack[pos], pos+1, stack, max);
        }
        if(pos+1<=stack.length-1)
        {
            System.out.println("Player2 picked 2 bricks: " + stack[pos] + " & " +stack[pos+1]);
            max = player1(score1, score2 + stack[pos] + stack[pos+1], pos+2, stack, max);
        }
        if(pos+2<=stack.length-1)
        {
            System.out.println("Player2 picked 3 bricks: " + stack[pos] + " & " +stack[pos+1]+ " & " + stack[pos+2]);
            max = player1(score1, score2 + stack[pos] + stack[pos+1] + stack[pos+2], pos+3, stack, max);
        }
        return max;
    }
}
