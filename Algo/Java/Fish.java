import java.util.*;

class Fish {

	  public int solution1(int[] A, int[] B) {
       Stack<Integer> st = new Stack<Integer>();
        int count=0;
        for(int i=0;i<A.length;i++){

        	if(st.empty() && B[i]==0){continue;};
        	if(B[i]==1){
        		st.push(i);
        		continue;
        	}
        	if(A[i] < A[st.peek()]){
        		count++;
        		continue;
        	}else{
        		st.pop();
        		count++;

        		boolean stop = false;
        		while(!stop && !st.empty()){
        			if(A[st.peek()] < A[i]){
        				st.pop();
        				count++;
        			}else{
        				stop = true;
        				count++;
        			}
        		}
        	}
        }
        return A.length - count;
    }

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int deadfish = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int i=1;i<A.length;i++)
        {
			boolean stop = false;
            if((B[stack.peek()]-B[i])>0)
            {
                if(A[stack.peek()]<A[i])
                {
                   while(!stack.isEmpty() && (B[stack.peek()]-B[i])>0 && !stop)
				   {
					   if(A[stack.peek()]>A[i])
					   {
						   stop = true;
						   deadfish++;
					   }
					   else if(!stack.isEmpty()&& A[stack.peek()]<A[i])
					   {
						   stack.pop();
						   deadfish++;
					   }
				   }
				   if(!stack.isEmpty() && (B[stack.peek()]-B[i])<1)
				   {
					   stack.push(i);
				   }
				   else if(stack.isEmpty())
				   {
					   stack.push(i);
				   }
                }
				else if(A[stack.peek()]>A[i])
				{
					deadfish++;
				}
            }
            else
            {
                stack.push(i);
            }
        }
        return stack.size();
    }

	public static void main(String args[])
	{
		Fish fish = new Fish();
		int A[] = {8,3,4};
		int B[] = {0, 1, 1};
		System.out.println(fish.solution(A, B));
		System.out.println(fish.solution1(A, B));
	}
}
