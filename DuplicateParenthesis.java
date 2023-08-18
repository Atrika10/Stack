import java.util.*;
public class DuplicateParenthesis {

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch != ')'){
                s.push(ch);
            }else{  // means I got closing bracket
                int count = 0;
                while(s.peek() != '('){  // I've not found opening pairs, so I'll pop & inc count
                    count++;
                    s.pop();
                }
                // here I found my opening bracket
                // step -3 
                if (count<1) { // means I found Duplicate
                    System.out.println("yes");
                    return true;
                }else{
                    s.pop();
                }

            }
        }
        System.out.println("No");
        return false;
    }
    public static void main(String[] args) {
        String str = "(b+c-d+(c))";
        
        System.out.println(isDuplicate(str));
    }
}
