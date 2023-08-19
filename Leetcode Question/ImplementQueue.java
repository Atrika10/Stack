import java.util.*;
public class ImplementQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        // base case if stack is already empty, I can't pop anything
        if (s1.isEmpty()) {
            return -1;
        }
        // step -1
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        // step -2 
        int topElem = s2.pop();
        // step -3 
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return topElem;
    }
    
    public int peek() {
        // base case if stack is already empty, I can't pop anything
        if (s1.isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }
        // step -1
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        // step -2 
        int topElem = s2.peek();
        // step -3 
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return topElem;
    }
    
    public boolean empty() {
        if (s1.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementQueue q = new ImplementQueue();
        q.push(0);
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.empty());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.empty());
        System.out.println(q.pop());

        
    }
    
}
