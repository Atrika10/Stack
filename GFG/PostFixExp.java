import java.util.*;
public class PostFixExp {

    /*
     * Time & space complexity is  O(n)
     * Approach
     * Iterate over the given string, 
     * step - 1 Each time, when I got a digit I'll push this in stack
     * step -2 otherwise (when I got any operator) I'll pich 2 element from stack & perform operation (lastTop operator Firsttop). & push this value in the stack
     * step - 3 return top element.
     * 
     */

    public static int evaluatePostFix(String s){
        Stack<Integer> st = new Stack<>();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '+' && ch != '-' && ch != '*'&& ch != '/' ) { // I got a digit
                int digit = ch -'0';
                st.push(digit);   
            }else{
                // after getting an operator, I'll pick top 2 element
                int e2 = st.pop();
                int e1 = st.pop();
                if(ch == '+'){
                    val =(int) e1+e2;
                    st.push(val);  // pushed the value after performing operation
                }else if(ch == '-'){
                    val =(int) e1-e2;
                    st.push(val);
                }
                else if(ch == '*'){
                    val =(int) e1*e2;
                    st.push(val);
                }else if(ch == '/'){
                    val =(int) e1/e2;
                    st.push(val);
                }
            }
        }
        return st.peek(); // finally, return the top value
    }
    public static void main(String[] args) {
        String s = "231*+9-";
        System.out.println(evaluatePostFix(s));
    }
}
