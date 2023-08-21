import java.util.*;

public class SimplifyPath {

    public static String path(String path) {
        if (path == "") {
            return "/";
        }

        Stack<String> s = new Stack<>();
        Stack<String> s2 = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        
        String arr[] = path.split("/");
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(".") && !arr[i].equals("..") && !arr[i].equals("")) {
                // means I've a file/directory name
                s.push(arr[i]);
            }else if(arr[i].equals("..") && !s.isEmpty()){
                s.pop();
            }
        }
        if (s.isEmpty()) {
            return "/";
        }else{
            while (!s.isEmpty()) {
                s2.push(s.pop());
            }
            while (!s2.isEmpty()) {
                sb.append("/" + s2.pop());
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "/home//foo/";
        String newStr = path(str);
        System.out.println(newStr);
    }

}