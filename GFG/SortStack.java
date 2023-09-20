import java.util.*;
public class SortStack {

    public static Stack<Integer> compareAndPush(Stack<Integer> s, int data){
        // base case
        if (s.isEmpty()) {
            s.push(data);
            return s;
        }
        // if data is already greater than top element, then we will push the data and return stack
        if (data > s.peek()) {  
            s.push(data);
            return s;
        }else{                  // else peek the top element & compare next top element by calling this function
            int top = s.pop();  
            compareAndPush(s, data);
            s.push(top);       // after pushing data, Now we can push current top element
        }
        return s;       // return stack
    }

    // Time & Space complexity => O(n) where n is the number of element of the stack
    public static Stack<Integer> sort(Stack<Integer> s){
        // base case
        if (s.isEmpty()) {
            return s;
        }
        // kaam
        int top = s.pop();  // pop the element
        sort(s);    // I believe sort function will sort the given element in the satck
        s = compareAndPush(s, top); // Now I'll push my element using compareAndPush function
		return s;
	}
    public static void printS (Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(40);
        s.push(42);
        s.push(10);
        s.push(50);
        s.push(38);
        s.push(80);
        sort(s);
        System.out.println("-----------");
        printS(s);
    }
}
