import java.util.*;
public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        // base case
        if (s == "") {
            return true;
        }

        // I'll push in stack if I got the opening brackets
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' ||ch == '[' ) {
                st.push(ch);
            }
            else{
                //corner case
                if(st.isEmpty()){
                    return false;
                }
                if((st.peek() == '(' && ch == ')') 
                  || (st.peek() == '{' && ch == '}')
                  || (st.peek() == '[' && ch == ']')){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        
        if (st.isEmpty()) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
