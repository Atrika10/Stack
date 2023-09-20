import java.util.*;
public class PushAtBottom {

    // Time & Space Complexity => O(n), where n is the size of the Stack
    public static Stack<Integer> insertAtBottom(Stack<Integer> St, int X) {
        // Taking a new Stack & pushing all elements from the given Stack
        Stack<Integer> s = new Stack<>();
        while (!St.isEmpty()) {
            s.push(St.pop());
        }
        // push the given element first
        St.push(X);
        // pushing all elements in the given Stack from our new Stack
        while (!s.isEmpty()) {
            St.push(s.pop());
        }
        return St;
    }
    public static void main(String[] args) {
        Stack<Integer> St = new Stack<>();
        St.push(4);
        St.push(3);
        St.push(2);
        St.push(1);
        St.push(8);
        Stack<Integer> St2 = new Stack<>();
        St2 = insertAtBottom(St, 2);
        while (!St2.isEmpty()) {
            System.out.println(St2.pop());
        }
    }
}
