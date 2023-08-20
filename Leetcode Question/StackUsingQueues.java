import java.util.*;
public class StackUsingQueues {

    static class Stack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int x){ // In whichever contains element, add element in that queue
            if (!q1.isEmpty()) {
                q1.add(x);
            }else{
                q2.add(x);
            }
        }

        public int pop(){
            if (q1.isEmpty() && q2.isEmpty()) {
                return -1;
            }
            int top = 1;
            if (!q1.isEmpty()) { // if q1 has elements
                
                while (!q1.isEmpty()) { // remove element until we got the last one & add element to q2
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }

            }else{ // if q2 has elements

                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }

            }

            return top;
        }
        public int peek(){
            if (q1.isEmpty() && q2.isEmpty()) {
                return -1;
            }
            int top = 1;
            if (!q1.isEmpty()) { // if q1 has elements
                
                while (!q1.isEmpty()) { 
                    top = q1.remove();
                    q2.add(top);
                }

            }else{ // if q2 has elements

                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }

            }

            return top;
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        
    }
    
}
