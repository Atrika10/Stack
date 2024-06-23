import java.util.*;

// Time & Space Complexity of this code is O(n), where n is the length of largest String

public class BackSpaceStrCmp {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();       // for first string
        Stack<Character> st2 = new Stack<>();       // for second string

        // Step -1 : pushing element into stack
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != '#'){          // push char if it's not #
                st1.push(ch);
            }else{  // remove the top 
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch != '#') {
                st2.push(ch);
            }else{
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            }
        }

        //Step -2 : pop & compare
        while (!st1.empty() && !st2.isEmpty()) {
            if (st1.pop() != st2.pop()) {       // if char is unequal
                return false;
            }
        }

        //Step -3 :  if still some char has left
        if (!st1.empty() || !st2.isEmpty()) {
            return false;
        }

        return true;    // finally return true if it hasn't returned false yet
        
    }
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }
}
