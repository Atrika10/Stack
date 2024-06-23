import java.util.*;
public class MinStack {
    
    // Time complexity of each method is O(1)
    // Space complexity of this program is O(n)     [O(n) + O(n) => O(2n) => O(n)] as we take 2 Arraylist extra

    ArrayList<Integer> al = new ArrayList<>();
    ArrayList<Integer> minInt = new ArrayList<>();  // to track min number

    public void push(int val) {
        al.add(val);
        if(minInt.size() == 0 || val <= minInt.get(minInt.size()-1)){   // only add min value
            minInt.add(val);
        }else{
            minInt.add(minInt.get(minInt.size()-1));  // add same value again to keep the minimum value at the same level as the main stack.
        }
    }
    
    public void pop() {
        if (al.size()>0) {      // if stack is not empty
            al.remove(al.size()-1);
            minInt.remove(minInt.size()-1);
        }
    }
    
    public int top() {
        if (al.size() >0) {
            return al.get(al.size()-1);
        }
        return Integer.MIN_VALUE;
    }
    
     public int getMin() {
        if (minInt.size()>0) {
            return minInt.get(minInt.size()-1); // return top value
        }else{
            return Integer.MIN_VALUE;
        }
     }
    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(5);
        st.push(15);
        st.push(25);
        st.push(65);
        System.out.println(st.top());
        st.pop();
        st.pop();
        System.out.println(st.top());
        System.out.println(st.getMin());
    
    }
}
