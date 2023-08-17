import java.util.*;
public class NextGreater {

    /*
        Traversing from backward of the given array as we need to analize next greater element on the right side.

        we will perform 3 steps for each element

        step - 1 : We Will run a loop until the stack is empty and the top element is large than my current element.

        step -2 : after getting out from the loop we'll check a condition is my stack is empty or not;  if stack is empty that means we don't have any greater element on the right side of this current element. else we have a element which is greater than my current element.
        
        step - 3 : push idx of my current element so that it can be accessible for the previous elements.
         */ 

    // Time & space complexity is O(n) 

    public static long[] nextLargerElement(long[] arr, int n){ 
        Stack<Integer> s = new Stack<>();
        long nextG[] = new long[arr.length];
        
        for (int i = n-1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextG[i] = -1;
            } else {
                nextG[i] = arr[s.peek()];  
            }

            s.push(i);
        }
        for (int i = 0; i < nextG.length; i++) {
            System.out.print(nextG[i] + " ");
        }
        return nextG;
    }

    public static void main(String[] args) {
        long arr[] = {1, 3, 2, 4};
        nextLargerElement(arr, arr.length);
    }
    
}
