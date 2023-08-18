import java.util.*;
public class PostFixExp {

    public static int evaluatePostFix(String s){
        Stack<Integer> st = new Stack<>();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '+' && ch != '-' && ch != '*'&& ch != '/' ) { // I got a digit
                int digit = ch -'0';
                st.push(digit);   
            }else{
                
                int e2 = st.pop();
                int e1 = st.pop();
                if(ch == '+'){
                    val =(int) e1+e2;
                    st.push(val);
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
        return st.peek();
    }
    public static void main(String[] args) {
        String s = "231*+9-";
        System.out.println(evaluatePostFix(s));
    }
}
