public class TwoStack {
    int arr[];
    int size;
    int top1, top2;
    TwoStack()
    {
        size = 100; 
        arr = new int[100]; 
        top1 = -1; 
        top2 = size;
    }
    //Function to push an integer into the stack1.
    void push1(int x)
    {
        top1++;
        arr[top1] = x;

    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
        top2--;
        arr[top2] = x; 
   
    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
        if(top1 == -1) { // stack is empty
            return -1;
        }
        int t = arr[top1];
        top1--;
        return t;
        
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        if(top2 == size) {
            return -1;
        }
        int t = arr[top2];
        top2++;
        return t;
    }
    public static void main(String[] args) {
       TwoStack s = new TwoStack();
       TwoStack s2 = new TwoStack();
        s.push1(2);
        s2.push2(20);
        System.out.println(s.pop1());
        System.out.println(s2.pop2());
        System.out.println(s2.pop2());
    }
}
