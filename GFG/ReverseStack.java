import java.util.*;
public class ReverseStack {

    public static void PushAtBottom(Stack<Integer> s, int data){
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        // work => pop element 
        int top = s.pop();
        PushAtBottom(s, data);
        s.push(top);
    }

    // Time Complexity => O(n) where n is the number of element in the gievn Stack
    // Space Complexity => O(1), we've not use any extra space 
    public static void reverse(Stack<Integer> s){
        // base case
        if (s.isEmpty()) {
            return;
        }
        // work 
        //pop element while going upward
        int top = s.pop();
        reverse(s); //next call
        PushAtBottom(s, top);   // now push element at bottom
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
  
        reverse(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
