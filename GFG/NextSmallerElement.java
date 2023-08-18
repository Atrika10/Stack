import java.util.*;
public class NextSmallerElement {

    public static int[] help_classmate(int arr[], int n) {
        Stack<Integer> s = new Stack<>();
        int nextSmaller[] = new int[arr.length];
        if (n == 0) {
            return nextSmaller;
        }
        //traverse from the end of the array
        nextSmaller[n-1] = -1;
        s.push(n-1); // idx of last element

        for (int i = n-2; i >= 0; i--) {
            // step 1 
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) { // if stack is not empty & top element is larger than current element
                s.pop();
            }
            // step - 2
            if (s.isEmpty()) {
                nextSmaller[i] = -1;
            }else{
                nextSmaller[i] = arr[s.peek()];
            }
            // step - 3 push idx of current element so that it can be accessible for prev elements
            s.push(i);

        }
        for (int i = 0; i < nextSmaller.length; i++) {
            System.out.print(nextSmaller[i] + " ");
        }
        return nextSmaller;
    }

    public static void main(String[] args) {
        int N = 5;
        int arr[] = {3, 8, 5, 2, 25};
        help_classmate(arr, N);
    }
}
