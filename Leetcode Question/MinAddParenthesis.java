import java.util.*;
public class MinAddParenthesis {

    public static int minAddToMakeValid(String s) {
        int count = 0;
        Stack<Character> st = new Stack<>();
        // base case
        if (s.length() == 0) {
            return count;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch =s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            }else{  // here, I got ')' bracket

                // I'll ckeck 2 conditions
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                    
                }else{
                    st.push(ch); // if my stack is empty or my top element is ')'; then I've to push
                    count++;
                }
            }
        }
        if (st.isEmpty()) {
            return count;
        }else{
            /*let Assume, currently, I've '))(' this in my stack, in prev loop I've counted '))' this only. To make it valid I've to count last '(' also.
             */ 
            while (!st.isEmpty()) {
                if (st.pop() == '(') {
                    count++; 
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        String s = "))(";
        System.out.println(minAddToMakeValid(s));
    }
}
