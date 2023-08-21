import java.util.*;
public class PalindromeLL {

    public static class Node{
        char ch;
        Node next;

        Node(char ch){
           this.ch = ch;
           this.next = null; 
        }
    }

    public static Node Head;
    public static Node Tail;


    public void addLast(char data){ // O(1)
        // step - 1 create newNode
        Node newNode = new Node(data);

        if (Head == null) {
            Head =Tail = newNode;
            return;
        }

        // step -2  linking step
        Tail.next = newNode;

        // step -3 update the tail
        Tail = newNode;
    }

    // TC & SC is O(n)

    public  boolean isPalindrome(Node head) 
    {
        Stack<Character> st = new Stack<>();
        Node temp = Head;
        // step 1 push all element in stack
        while (temp != null) {
            st.push(temp.ch);
            // update temp
            temp = temp.next;
        }

        // step -2 pop each element from stack & compare with head.data
        while (Head != null) {
            if (Head.ch != st.pop()) {
                return false;
            }
            // update head
            Head = Head.next;
        }
        return true;
    } 

    public static void main(String args[]){
        PalindromeLL ll = new PalindromeLL();
        ll.addLast('A');
        ll.addLast('B');
        ll.addLast('C');
        ll.addLast('B');
        ll.addLast('A');
        System.out.println(ll.isPalindrome(Head));
    }
}
