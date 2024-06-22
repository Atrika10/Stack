import java.util.*;

public class ReverseWordsInStr{
    public static String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");

        // Step - Traverse & push words
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ' '){
                sb.append(ch);
            }else{
                if(sb.length() > 0){    // I've something to push
                    st.push(sb.toString());
                    sb = new StringBuilder();   // update sb
                }
            }
        }
        // still, If I've one more word
        if(sb.length() > 0){
            st.push(sb.toString());
        }

        // step - 2 remove element & return final string
        sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
            if (!st.empty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "the sky     is blue";
        String str = reverseWords(s);
        System.out.println(str);
    }
}