import java.lang.reflect.Array;
import java.util.*;
public class ReverseStr{

    public static String reverseStr(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        // push all char of given str
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder("");
        // pop all char from stack & append it to sb
        while (!s.isEmpty()) {
            char ch = s.pop();
            sb.append(ch);
        }

        return sb.toString();
    }

    // Time & Space complexity O(n), n= size of the Array

    public static void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        int i =0;
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            s[i] = ch;
            i++;
        }
    }

    public static void main(String[] args) {
        // String str = "atrika";
        // String s = reverseStr(str);
        //  System.out.println(s);   
        char s[] = {'h','e','l','l','o'} ;
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
        
    }
}