import java.util.*;
public class ReduntantParenthesis {

    // Tc & Sc is O(n)
    /*
     * Here I've to check is there any redundant parenthesis or not?
     * if no operator is available in between a particular parenthsis, then I can say there is redundant parenthesis
     * Approach :
     * step - 1 : push all the element without closing bracket.
     * step -2 : after getting closing bracket, will check is it any operator or not, if it is, 
     *              then inc count(a var to track operator)
     * step -3 : if count<1 means there is no operator in between a particular parenthsis,return => true
     */

    public static boolean checkRedundancy(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch != ')'){
                s.push(ch);
            }else{  // step 2: fount closing bracket
                int count = 0;
                while(s.peek() != '('){  
                    if (s.peek() == '+' || s.peek() == '-' || s.peek() == '*' || s.peek() == '/') {
                        count++;
                    }
                    s.pop();
                }
                // here I found my opening bracket
                // step -3 
                if (count<1) { // here I found redundant parenthesis
                    return true;
                }else{
                    s.pop();
                }

            }
        }
        return false;
    }
    

    public static void main(String[] args) {
        String str = "(b+c-d+(c))";
        System.out.println(checkRedundancy(str));
    }
    
}
